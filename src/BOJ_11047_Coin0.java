import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11047번 - 동전 0
public class BOJ_11047_Coin0 {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int result=0;

        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] > K) continue;
            else {
                result += K / coins[i];
                K = K % coins[i];
            }
        }
        System.out.println(result);
    }
}
