import ai.classifai.loader.ProjectLoader;
import ai.classifai.selector.project.LabelListSelector;
import ai.classifai.selector.project.ProjectFolderSelector;
import ai.classifai.util.type.AnnotationType;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;
import java.util.Objects;

@Slf4j
public class LoaderSetup {


    @Getter @Setter
    private static String projectName;
    @Getter @Setter
    private static int annotationType;
    @Getter @Setter
    private static List<String> testLabelList;
    @Getter
    private static String testDataDir = "src/test/resources/testImages";

    public static ProjectLoader createNewTestProject() {

        ProjectFolderSelector projectFolderSelector = new ProjectFolderSelector();

        ProjectLoader loader = Objects.requireNonNull(projectFolderSelector.configureLoader(
                projectName,
                annotationType,
                new File(testDataDir)
        ));

        loader.setLabelList(testLabelList);

        return loader;
    }

}
