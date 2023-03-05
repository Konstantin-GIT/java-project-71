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
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        String actual = Differ.generate(path1, path2, format);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateForYaml() throws IOException {
        String path1 = "src/main/resources/file1.yaml";
        String path2 = "src/main/resources/file2.yaml";
        String format = "stylish";

        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        String actual = Differ.generate(path1, path2, format);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateForYamlOutputPlain() throws IOException {
        String path1 = "src/main/resources/file1.yaml";
        String path2 = "src/main/resources/file2.yaml";
        String format = "plain";

        String expected = "Property 'chars2' was update. From [d, e, f] to false\n"
                + "Property 'checked' was update. From false to true\n"
                + "Property 'default' was update. From null to [value1, value2]\n"
                + "Property 'id' was update. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was update. From [2, 3, 4, 5] to [22, 33, 44, 55]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [4, 5, 6]\n"
                + "Property 'obj1' was added with value: {nestedKey=value, isNested=true}\n"
                + "Property 'setting1' was update. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was update. From 200 to 300\n"
                + "Property 'setting3' was update. From true to 'none'\n";
        String actual = Differ.generate(path1, path2, format);
        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateForJsonOutputPlain() throws IOException {
        String path1 = "src/main/resources/file1.json";
        String path2 = "src/main/resources/file2.json";
        String format = "plain";

        String expected = "Property 'chars2' was update. From [d, e, f] to false\n"
                + "Property 'checked' was update. From false to true\n"
                + "Property 'default' was update. From null to [value1, value2]\n"
                + "Property 'id' was update. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was update. From [2, 3, 4, 5] to [22, 33, 44, 55]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [4, 5, 6]\n"
                + "Property 'obj1' was added with value: {nestedKey=value, isNested=true}\n"
                + "Property 'setting1' was update. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was update. From 200 to 300\n"
                + "Property 'setting3' was update. From true to 'none'\n";
        String actual = Differ.generate(path1, path2, format);
        assertEquals(expected, actual);
    }
}
