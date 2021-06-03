package ai.classifai.action;

import ai.classifai.TestHelper;
import io.vertx.core.json.JsonObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class ProjectImportTest {
    @DisplayName("Check json keys success case")
    @ParameterizedTest
    @MethodSource("testCheckJsonKeysSuccessSource")
    void testCheckJsonKeysSuccess(JsonObject inputJsonObject) {
        boolean output = ProjectImport.checkJsonKeys(inputJsonObject);
        Assertions.assertTrue(output);
    }

    static Stream<JsonObject> testCheckJsonKeysSuccessSource() throws IOException, ParseException {
        return Stream.of(
                TestHelper.readJsonFile("src/test/resources/SuccessCase.json")
        );
    }

    @DisplayName("Check json keys fail case")
    @ParameterizedTest
    @MethodSource("testCheckJsonKeysFailSource")
    void testCheckJsonKeysFail(JsonObject inputJsonObject) {
        boolean output = ProjectImport.checkJsonKeys(inputJsonObject);
        Assertions.assertFalse(output);
    }

    static Stream<JsonObject> testCheckJsonKeysFailSource() throws IOException, ParseException {
        return Stream.of(
                TestHelper.readJsonFile("src/test/resources/FailCaseIncorrectKeySpelling.json"),
                TestHelper.readJsonFile("src/test/resources/FailCaseMissingKey.json")
        );
    }
}
