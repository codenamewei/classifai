package ai.classifai.action.source.annotation.image.yolo;

import ai.classifai.data.type.image.ImageData;
import ai.classifai.data.type.image.ImageDataFactory;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class YoloFormat
{
    private List<Integer> labelList = new ArrayList<>();

    private List<Integer[]> bboxList = new ArrayList<>();
    private List<String> labelNameList = new ArrayList<>();

    private int imgWidth;
    private int imgHeight;
    private int imgDepth;

    private static final int LABEL_MIN_LENGTH = 5;
    private static final int LABEL_MAX_LENGTH = 7;

    private final int TOTAL_NUM_LABELS;
    private Path imgPath;

    public YoloFormat(List<String> inputYoloLabels, List<String> labelRefList, Path inputImgPath, int totalLabels)
    {
        TOTAL_NUM_LABELS = totalLabels;

        imgPath = inputImgPath;

        try
        {
            Metadata metadata = ImageMetadataReader.readMetadata(imgPath.toFile());

            ImageData imgData = new ImageDataFactory().getImageData(metadata);

            imgWidth = imgData.getWidth();
            imgHeight = imgData.getHeight();
            imgDepth = imgData.getDepth();

        }
        catch(Exception e)
        {
            log.info("Error in reading image " + imgPath.toAbsolutePath() + ": ", e);
        }

        inputYoloLabels.forEach((line) ->
        {
            String[] splittedLine = line.split(" ");

            insertValidLabel(splittedLine, labelRefList);
        });
    }

    //x, y, w, h -> x1, y1, x2, y2
    private void loadX1Y1X2Y2(double x, double y, double width, double height)
    {
        double x1 = x * imgWidth;
        double y1 = y * imgHeight;

        double x2 = x1 + width * imgWidth;
        double y2 = y1 + height * imgHeight;

        Integer[] bbox = {(int) x1, (int) y1, (int) x2, (int) y2};

        bboxList.add(bbox);
    }

    private void insertValidLabel(String[] labelElement, List<String> labelRefList)
    {
        if((labelElement.length >= LABEL_MIN_LENGTH)
                && (labelElement.length < LABEL_MAX_LENGTH))
        {
            try
            {
                int labelIndex = Integer.parseInt(labelElement[0]);
                double x = Double.parseDouble(labelElement[1]);
                double y = Double.parseDouble(labelElement[2]);

                double width = Double.parseDouble(labelElement[3]);
                double height = Double.parseDouble(labelElement[4]);

                if((labelIndex < TOTAL_NUM_LABELS) && inRange(x) && inRange(y) && inRange(width) && inRange(height))
                {
                    labelList.add(labelIndex);
                    labelNameList.add(labelRefList.get(labelIndex));

                    loadX1Y1X2Y2(x, y, width, height);

//                    System.out.println("Labels: " + labelIndex);
//
//                    System.out.println("x: " + x);
//                    System.out.println("y: " + y);
//
//                    System.out.println("w: " + width);
//                    System.out.println("h: " + height);
                }
                else
                {
                    log.info("YOLO label value out of range");
                }

            }
            catch(Exception e)
            {
                log.info("YOLO parsing value error: ", e);
            }
        }
    }

    private boolean inRange(double value)
    {
        return ((value >= 0.0) && (value <= 1.0)) ? true : false;
    }
}