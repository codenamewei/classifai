import ai.classifai.loader.ProjectLoader;
import ai.classifai.util.type.AnnotationType;
import org.junit.jupiter.api.*;

import java.util.List;

public class StarProjectAPITest {
    private static ProjectLoader loader = null;

    @BeforeEach
    public void prepareProject() {
        LoaderSetup.setProjectName("TestProject");
        LoaderSetup.setAnnotationType(AnnotationType.BOUNDINGBOX.ordinal());
        LoaderSetup.setTestLabelList(List.of("First", "Second", "Third"));
        loader = LoaderSetup.createNewTestProject();
    }

    @Test
    @DisplayName("Create project")
    void testCreateProject() {
        Assertions.assertEquals(
                List.of(
                        loader.getProjectName(), loader.getAnnotationType(), loader.getLabelList()
                ),
                List.of(
                        LoaderSetup.getProjectName(), LoaderSetup.getAnnotationType(), LoaderSetup.getTestLabelList()
                )
        );
    }

}
