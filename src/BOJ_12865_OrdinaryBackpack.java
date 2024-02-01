import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_OrdinaryBackpack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] backpack = new int[n + 1][k + 1];
        int max = 0;

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for (int j = 1; j < k + 1; j++) {

                if (j < w) {
                    backpack[i][j] = backpack[i - 1][j];
                } else {
                    backpack[i][j] = Math.max(backpack[i - 1][j - w] + v, backpack[i - 1][j]);
                }

                if (backpack[i][j] > max) {
                    max = backpack[i][j];
                }
            }
        }

        System.out.println(max);

    }
}
