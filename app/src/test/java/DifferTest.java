import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private static String resultJsonStylish;
    private static String resultJsonPlain;
    private static String resultYamlPlain;

    // Построение путей до фикстур не дублируется
    // Сами данные хранятся в текстовых файлах (фикстурах), а не в самих тестах.
    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    // Побочные эффекты правильно делать не на уровне класса, а внутри хуков
    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJsonStylish = readFixture("result_json_stylish.json");
        resultJsonPlain = readFixture("result_json_plain.txt");
        resultYamlPlain = readFixture("result_yaml_plain.txt");
    }

    @Test
    public void testGenerateForJson() throws IOException {
        String path1 = "src/main/resources/fixtures/file1.json";
        String path2 = "src/main/resources/fixtures/file2.json";
        String format = "stylish";

        String expected = resultJsonStylish;
        String actual = Differ.generate(path1, path2, format);
        assertEquals(expected, actual);
    }


    @Test
    public void testGenerateForYamlOutputPlain() throws IOException {
        String path1 = "src/main/resources/fixtures/file1.yml";
        String path2 = "src/main/resources/fixtures/file2.yml";
        String format = "plain";

        String expected = resultYamlPlain;
        String actual = Differ.generate(path1, path2, format);
        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateForJsonOutputPlain() throws IOException {
        String path1 = "src/main/resources/fixtures/file1.json";
        String path2 = "src/main/resources/fixtures/file2.json";
        String format = "plain";

        String expected = resultJsonPlain;
        String actual = Differ.generate(path1, path2, format);
        assertEquals(expected, actual);
    }
}
