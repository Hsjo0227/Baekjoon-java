import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BOJ_1193_FindingFraction {

    public static void main(String[] args) throws IOException {
        String answer = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int n = 1;

        while (X > n) {
            X = X - n;
            n++;
        }
        if ((n + 1) % 2 == 0) {
            answer = (n + 1 - X) + "/" + X;
        } else {
            answer = X + "/" + (n + 1 - X);
        }
        System.out.println(answer);

    }
}
