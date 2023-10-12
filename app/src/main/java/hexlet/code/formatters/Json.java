package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;

public class Json {
    public static String formatting(Map<String, List<String>> inp)
            throws JsonProcessingException {
        ObjectMapper object = new ObjectMapper();
        return object.writeValueAsString(inp);
    }
}
