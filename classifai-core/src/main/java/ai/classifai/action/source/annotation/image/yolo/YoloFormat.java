package ai.classifai.action.source.annotation.image.yolo;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
class YoloFormat
{
    @Getter
    private List<Integer> labelList = new ArrayList<>();

    //x, y, w, h
    @Getter private List<Double[]> bboxList = new ArrayList<>();

    private static final int LABEL_MIN_LENGTH = 5;
    private static final int LABEL_MAX_LENGTH = 7;

    private final int TOTAL_NUM_LABELS;

    public YoloFormat(List<String> inputYoloLabels, int totalLabels)
    {
        TOTAL_NUM_LABELS = totalLabels;

        inputYoloLabels.forEach((line) ->
        {
            String[] splittedLine = line.split(" ");

            insertValidLabel(splittedLine);
        });
    }

    private void insertValidLabel(String[] labelElement)
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

                    Double[] bbox = {x, y, width, height};

//                    System.out.println("Labels: " + labelIndex);
//
//                    System.out.println("x: " + x);
//                    System.out.println("y: " + y);
//
//                    System.out.println("w: " + width);
//                    System.out.println("h: " + height);

                    bboxList.add(bbox);
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