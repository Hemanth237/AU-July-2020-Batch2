import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import static java.util.stream.Collectors.toList;


public class advques10 {
    private static Object FileUtils;
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("C:\\Users\\RangaReddy\\Desktop");
        Path destination = Paths.get("C:\\Users\\RangaReddy\\Documents");

        List<Path> sources = Files.walk(source).collect(toList());
        List<Path> destinations = sources.stream()
                .map(source::relativize)
                .map(destination::resolve)
                .collect(toList());

        for (int i = 0; i < sources.size(); i++) {
            Files.copy(sources.get(i), destinations.get(i));
        }
    }

}
