package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class DifferTest {
    private final String filePath1 = "src/test/resources/file1.json";
    private final String filePath2 = "src/test/resources/file2.json";
    private final String filePath3 = "src/test/resources/file1.yml";
    private final String filePath4 = "src/test/resources/file2.yml";
    private final String sample = "src/test/resources/sample";
    private final String sample1 = "src/test/resources/sample1";
    private final String sample2 = "src/test/resources/sample2";
    private final String sample3 = "src/test/resources/sample3";
    @Test
    public void testJson() throws Exception {
        assertEquals(Files.readString(Path.of(sample1)), Differ.generate(filePath1, filePath2, "stylish"));
    }
    @Test
    public void testYaml() throws Exception {
        assertEquals(Files.readString(Path.of(sample)), Differ.generate(filePath3, filePath4));
    }
    @Test
    public void testJsonPlain() throws Exception {
        assertEquals(Files.readString(Path.of(sample2)), Differ.generate(filePath1, filePath2, "plain"));
    }
    @Test
    public void testDiffToJson() throws Exception {
        assertEquals(Files.readString(Path.of(sample3)), Differ.generate(filePath1, filePath2, "json"));
    }
}

