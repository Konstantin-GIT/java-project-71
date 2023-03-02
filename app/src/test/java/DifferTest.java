import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    public void testGenerateForJson() throws IOException {
        String path1 = "src/main/resources/file1.json";
        String path2 = "src/main/resources/file2.json";
        String format = "stylish";

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String actual = Differ.generate(path1, path2, format);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateForYaml() throws IOException {
        String path1 = "src/main/resources/file1.yaml";
        String path2 = "src/main/resources/file2.yaml";
        String format = "plain";

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String actual = Differ.generate(path1, path2, format);
        assertEquals(expected, actual);
    }
}
