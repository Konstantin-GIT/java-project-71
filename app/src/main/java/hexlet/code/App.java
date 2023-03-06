package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "gendiff",  version = "gendiff 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable {
    @Option(names = { "-f", "--format" }, paramLabel = "format",
        description = "output format [default: stylish]", defaultValue = "stylish")
    public static String format;
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filePath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filePath2;


    @Override
    public String call() throws IOException {
        String differBetweenTwoFiles = "Method execution error";
        try {
            differBetweenTwoFiles = Differ.generate(filePath1, filePath2, format);
        } catch (IOException e) {
            System.out.println(e);
            return e.toString();
        }
        return differBetweenTwoFiles;
    }

    public static void main(String[] args) throws IOException {
        try {
            App app = new App();
            int exitCode = new CommandLine(app).execute(args);
            System.exit(exitCode);
            app.call();
        } catch (IOException e) {
            System.out.println();
        }
    }
}

