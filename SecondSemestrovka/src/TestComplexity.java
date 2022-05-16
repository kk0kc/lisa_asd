import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestComplexity {
    public static void main(String[] args) throws IOException {
        long t1;
        System.out.println("1 test");
        for (int n = 1; n < 101; n++) {
            t1 = 0;
            for (int k = 0; k < 25; k++) {
                FileReader file = new FileReader("SecondSemestrovka/FilesForTest/FILE " + n + ".txt");
                Scanner scanner = new Scanner(file);
                Point[] list = new Point[n*50];
                for (int i = 0; i < n*50; i++) {
                    int value1 = scanner.nextInt();
                    int value2 = scanner.nextInt();
                    list[i] = new Point(value1, value2);
                }
                long start1 = System.nanoTime();
                Point.seekDistance(list);
                long finish1 = System.nanoTime();
                t1 += (finish1 - start1);
                file.close();
            }
            System.out.println(t1/25 );
        }
    }
}
