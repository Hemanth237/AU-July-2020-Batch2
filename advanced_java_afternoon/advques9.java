import java.io.*;

public class advques9 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("output.txt", true);
        String s;
        while ((s = br.readLine()) != null) { // read a line
            fw.write(s); // write to output file
            fw.flush();
        }
        br.close();
        fw.close();
        System.out.println("file copied");
    }
}
