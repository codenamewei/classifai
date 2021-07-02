package ai.classifai.action.source.annotation.image.yolo;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class YoloLabelParser
{
    @Getter private List<String> labelRefDict;
    @Getter private List<YoloFormat> yoloContent = new ArrayList<>();

    public YoloLabelParser(File labelTxtFile)
    {
        try
        {
            String labels = IOUtils.toString(new java.io.FileReader(labelTxtFile));

            labelRefDict = Arrays.asList(labels.split("\n"));
        }
        catch(Exception e)
        {
            log.debug("Error in loading label: ", e);
        }
    }

}
