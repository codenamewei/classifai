package ai.classifai;

import io.vertx.core.json.JsonObject;
import org.apache.commons.io.IOUtils;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class TestHelper {
    public static JsonObject readJsonFile(String fileName) throws IOException, ParseException {
        String jsonStr = IOUtils.toString(new FileReader(fileName));

        return new JsonObject(jsonStr);
    }
}
