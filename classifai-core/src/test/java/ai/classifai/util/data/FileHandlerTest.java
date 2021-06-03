package ai.classifai.util.data;

import ai.classifai.data.type.image.ImageFileType;
import ai.classifai.util.data.FileHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileHandlerTest {
    @Test
    @DisplayName("Check supported file")
    void testisFileSupported()
    {
        String fileName = "image.jpg";
        boolean result = FileHandler.isFileSupported(fileName, ImageFileType.getImageFileTypes());
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Check supported file directory string")
    void testisFileSupportedDirectoryString()
    {
        String fileName = "path/to/my/image.jpg";
        boolean result = FileHandler.isFileSupported(fileName, ImageFileType.getImageFileTypes());
        Assertions.assertTrue(result);
    }
}
