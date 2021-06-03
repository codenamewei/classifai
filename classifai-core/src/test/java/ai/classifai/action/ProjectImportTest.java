package ai.classifai.action;

import ai.classifai.TestHelper;
import io.vertx.core.json.JsonObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class ProjectImportTest {
    @ParameterizedTest
    @MethodSource("jsonKeysSource")
    void testCheckJsonKeys(JsonObject inputJsonObject) {
        boolean output = ProjectImport.checkJsonKeys(inputJsonObject);
        Assertions.assertTrue(output);
    }

    static Stream<JsonObject> jsonKeysSource() throws IOException, ParseException {
        return Stream.of(
                TestHelper.readJsonFile("src/test/resources/FirstProject.json")
        );
    }
}
