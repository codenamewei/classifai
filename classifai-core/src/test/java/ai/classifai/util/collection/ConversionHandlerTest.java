package ai.classifai.util.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConversionHandlerTest {
    @Test
    @DisplayName("String to boolean lower case")
    void testString2boolean() throws Exception {
        String input = "true";
        boolean result = ConversionHandler.String2boolean(input);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("String to boolean upper case")
    void testString2booleanUpperCase() throws Exception {
        String input = "TRUE";
        boolean result = ConversionHandler.String2boolean(input);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("String to boolean mixed case")
    void testString2booleanMixedCase() throws Exception {
        String input = "True";
        boolean result = ConversionHandler.String2boolean(input);
        Assertions.assertTrue(result);
    }

}
