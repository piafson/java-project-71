package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DifferTest {
    private final String filePath1 = "src/test/resources/file1.json";
    private final String filePath2 = "src/test/resources/file2.json";
    private final String filePath3 = "src/test/resources/file1.yml";
    private final String filePath4 = "src/test/resources/file2.yml";
    private final String sample = "{\n"
            + "  - follow: false\n" + "    host: hexlet.io\n"
            + "  - proxy: 123.234.53.22\n" + "  - timeout: 50\n"
            + "  + timeout: 20\n" + "  + verbose: true\n}";
    private final String sample1 = "{\n"
            + "    chars1: [a, b, c]\n" + "  - chars2: [d, e, f]\n"
            + "  + chars2: false\n" + "  - checked: false\n"
            + "  + checked: true\n" + "  - default: null\n"
            + "  + default: [value1, value2]\n" + "  - id: 45\n"
            + "  + id: null\n" + "  - key1: value1\n"
            + "  + key2: value2\n" + "    numbers1: [1, 2, 3, 4]\n"
            + "  - numbers2: [2, 3, 4, 5]\n" + "  + numbers2: [22, 33, 44, 55]\n"
            + "  - numbers3: [3, 4, 5]\n" + "  + numbers4: [4, 5, 6]\n"
            + "  + obj1: {nestedKey=value, isNested=true}\n" + "  - setting1: Some value\n"
            + "  + setting1: Another value\n" + "  - setting2: 200\n"
            + "  + setting2: 300\n" + "  - setting3: true\n" + "  + setting3: none\n}";
    @Test
    public void testJson() throws Exception {
        assertEquals(sample1, Differ.generate(filePath1, filePath2));
    }
    @Test
    public void testYaml() throws Exception {
        assertEquals(sample, Differ.generate(filePath3, filePath4));
    }
}

