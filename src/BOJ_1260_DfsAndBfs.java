import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;


public class BOJ_1260_DfsAndBfs {
        static int N;
        static int M;
        static int V;
        static int[][] adj;
        static boolean[] visited;
        static Queue<Integer> queue = new LinkedList<>();
        static StringBuilder sb = new StringBuilder();
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            adj = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                adj[start][end] = adj[end][start] = 1;
            }

            dfs(V);
            System.out.println(sb);

            sb.setLength(0);
            Arrays.fill(visited, false);
            queue.offer(V);
            visited[V] = true;
            bfs();
            System.out.println(sb);
        }

        public static void dfs(int start) {
            visited[start] = true;
            sb.append(start).append(" ");
            for(int i = 1; i <= N; i++) {
                if(adj[start][i] == 0 || visited[i]) continue;
                dfs(i);
            }
        }

        public static void bfs() {
            while(!queue.isEmpty()) {
                int now = queue.poll();
                sb.append(now).append(" ");
                for (int i = 1; i <= N; i++) {
                    if(adj[now][i] == 0 || visited[i]) continue;
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
}
