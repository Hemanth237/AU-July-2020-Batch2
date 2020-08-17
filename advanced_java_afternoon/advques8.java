import java.io.File;
import java.io.FilenameFilter;
public class advques8 {
    public static void main(String[] args) {
        File folder = new File("C:/Path");
        FilenameFilter txtFileFilter = new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.endsWith(".txt");
            }
        };
        File[] files = folder.listFiles(txtFileFilter);

        for (File file : files)
        {
            if (file.delete()) {
                System.out.println("File deleted successfully");
            } else {
                System.out.println("Failed to delete the file");

            }
        }
    }

}
