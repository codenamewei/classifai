package ai.classifai.action.source.annotation.image.yolo;

import lombok.Builder;
import lombok.Getter;

import java.io.File;

@Builder
@Getter
public class YoloProj
{
    private String projectName;
    private File projectPath;
    private File labelFilePath;
}
