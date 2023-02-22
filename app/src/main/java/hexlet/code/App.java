package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

@Command(name = "gendiff",  version = "Differ 1.0", mixinStandardHelpOptions = true,  description = "Compares two configuration files and shows a difference.")
public class App implements Runnable{

    @Option(names = { "-f", "--format" }, paramLabel = "format", description = "output format [default: stylish]", defaultValue = "stylish")
    String format;

    @Parameters(paramLabel = "filepath1",
            description = "path to first file")
    private String filepath1;

    @Parameters(paramLabel = "filepath2",
            description = "path to second file")
    private String filepath2;
    // @Override
    public void run() {
        // The business logic of the command goes here...
        // In this case, code for generation of ASCII art graphics
        // (omitted for the sake of brevity).
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

