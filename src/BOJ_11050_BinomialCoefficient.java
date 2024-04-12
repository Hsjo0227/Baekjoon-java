import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11050_BinomialCoefficient {
    static int[][] dp;

    public static int search(int n, int k) {
        if(dp[n][k] > 0) return dp[n][k];

        if(n == k || k == 0) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = search(n-1, k-1) + search(n-1, k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];

        int result = search(N, K);

        System.out.println(result);


    }
}
