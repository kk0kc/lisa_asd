import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {
    public static void main(String[] args) throws IOException {
        int n = 1;
        Random random = new Random();
        while (n != 101) {
            int k = 0;
            int bound = 100 * n;
            FileWriter nfile = new FileWriter("SecondSemestrovka/FilesForTest/FILE " + n + ".txt");
            while (k != bound) {
                int generatedNum = random.nextInt(10000) + 1000;
                nfile.write("" + generatedNum);
                nfile.write("\n");
                k++;
            }
            n++;
            nfile.close();
        }
    }
}
