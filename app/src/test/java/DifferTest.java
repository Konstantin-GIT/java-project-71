import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    public void testGenerate() throws IOException {
        String path1 = "/home/konstantin/Hexlet/java-project-71/app/src/main/resources/file1.json";
        String path2 = "/home/konstantin/Hexlet/java-project-71/app/src/main/resources/file2.json";

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);
    }
}
