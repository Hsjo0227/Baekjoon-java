import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2577_CountOfNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int num  = a * b * c;
        String str = String.valueOf(num);

        int[] counts = new int[10];

        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            counts[digit]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(counts[i]);
        }

    }
}