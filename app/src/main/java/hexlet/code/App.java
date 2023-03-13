package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;

@Command(name = "gendiff",  version = "gendiff 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable {
    @Option(names = { "-f", "--format" }, paramLabel = "format",
        description = "output format [default: stylish]", defaultValue = "stylish")
    private static String formatOutput;
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filePath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filePath2;


    @Override
    public Integer call() {
        try {
            String formattedDiff = Differ.generate(filePath1, filePath2, formatOutput);
            System.out.println(formattedDiff);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        App app = new App();
        int exitCode = new CommandLine(app).execute(args);
        System.exit(exitCode);
    }
}

