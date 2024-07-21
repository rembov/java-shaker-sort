import java.util.Random;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("res.txt", false);
        int[] ch = new int[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            ch[i] = rand.nextInt(100);
            writer.append(ch[i] + ",");

            writer.flush();
        }
        writer.append("\n");

        writer.append("---------------------------------------------"
                + "------------------------------------------------"
                + "---------------------------------------------------"
                + "----------------------------------------------------"
                + "---------------------------");
        writer.append("\n");
        writer.flush();
        shekerSort(ch, 100);
        for (int i = 0; i < 100; i++) {
            writer.append(ch[i] + ",");

            writer.flush();

        }
        writer.append("\n");
        System.out.println("ok");

        try (FileReader reader = new FileReader("res.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {

                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }

        }
    }

    private static void shekerSort(int[] mass, int count) {
        int left = 0, right = count - 1;
        int flag = 1;

        while ((left < right) && flag > 0) {
            flag = 0;
            for (int i = left; i < right; i++) {
                if (mass[i] > mass[i + 1]) {
                    int t = mass[i];
                    mass[i] = mass[i + 1];
                    mass[i + 1] = t;
                    flag = 1;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (mass[i - 1] > mass[i]) {
                    int t = mass[i];
                    mass[i] = mass[i - 1];
                    mass[i - 1] = t;
                    flag = 1;
                }
            }
            left++;
            if (flag == 0) break;
        }
    }

}