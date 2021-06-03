package ai.classifai.util.data;

import ai.classifai.util.data.StringHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StringHandlerTest {

    @Test
    @DisplayName("Remove forward slash")
    void testRemoveForwardSlash()
    {
        String input = "/mypath";
        String output = StringHandler.removeSlashes(input);
        Assertions.assertEquals("mypath", output);
    }

    @Test
    @DisplayName("Remove back slash")
    void testRemoveBackSlash()
    {
        String input = "\\mypath";
        String output = StringHandler.removeSlashes(input);
        Assertions.assertEquals("mypath", output);
    }

    @Test
    @DisplayName("Remove forward slash & back slash")
    void testRemoveForwardSlashBackSlash()
    {
        List<String> inputs = List.of("\\/mypath", "\\\\mypath", "\\//mypath");
        String expectedOutput = "mypath";
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedOutput, StringHandler.removeSlashes(inputs.get(0))),
                () -> Assertions.assertEquals(expectedOutput, StringHandler.removeSlashes(inputs.get(1))),
                () -> Assertions.assertEquals(expectedOutput, StringHandler.removeSlashes(inputs.get(2)))
        );
    }
}
