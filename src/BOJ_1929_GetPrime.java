import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_GetPrime {
    public static boolean[] primeNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        primeNumber = new boolean[N + 1];
        primeNumber[0] = true;
        primeNumber[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (primeNumber[i]) continue;
            for (int j = i * i; j <= N; j += i) {
                primeNumber[j] = true;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = M; i <= N; i++) {
            if (!primeNumber[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);


    }
}
