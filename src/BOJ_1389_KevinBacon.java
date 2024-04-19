import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class BOJ_1389_KevinBacon {
    static int[][] adj;
    static final int INF = 9999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(adj[i], INF);
            adj[i][i] = 0;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start - 1][end - 1] = adj[end - 1][start - 1] = 1;
        }

        int[][] floyd = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                floyd[i][j] = adj[i][j];
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++){
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }

        int min = N * N;
        int answer = 0;

        for(int i = 0; i < N; i++) {
            int score = 0;
            for(int j = 0; j < N; j++){
                score += floyd[i][j];
            }
            if(score < min) {
                min = score;
                answer = i + 1;
            }
        }

        System.out.println(answer);
    }
}