package ai.classifai.action.source.annotation.image.yolo;

import ai.classifai.loader.ProjectLoader;
import ai.classifai.util.data.FileHandler;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class YoloLabelParser
{
    private static final String LABEL_EXT = ".txt";

    public YoloFormat run(@NonNull ProjectLoader loader, @NonNull String imgFileName)
    {
        Path targetPathImg = Paths.get(loader.getProjectPath().getAbsolutePath(), imgFileName);
        System.out.println("Img: " + targetPathImg.toString());

        String fileName = FileHandler.getFileNameWithoutExt(targetPathImg.toFile());

        Path labelFile = Paths.get(loader.getYoloLabelPath().toString(), fileName + LABEL_EXT);

        if(!labelFile.toFile().exists())
        {
            // alternatives to find label file
            String parent = targetPathImg.getParent().toString();

            if(parent.contains("images")) parent = parent.replace("images", "labels");

            labelFile = Paths.get(parent, fileName + LABEL_EXT);

            if(!labelFile.toFile().exists()) log.info("label file for " + targetPathImg.toString() + " not found. Skip import labels.");
        }

        System.out.println("Txt: " + labelFile.toString());

        try
        {
            String labels = IOUtils.toString(new FileReader(labelFile.toFile()));

            List<String> inputLabelLine = Arrays.asList(labels.split("\n"));

            return new YoloFormat(inputLabelLine, targetPathImg, loader.getLabelList().size());

        }
        catch(Exception e)
        {
            log.info("Error when loading label file: ", labelFile.toString());
        }

        return null;
    }
}
