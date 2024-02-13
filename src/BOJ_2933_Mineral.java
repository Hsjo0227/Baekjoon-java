import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2933번 - 미네랄
public class BOJ_2933_Mineral {
    static void throwStick(int n, int cnt) {
        // 홀수 회차일때 왼쪽 첫번째 미네랄을 삭제
        if (cnt % 2 == 1) {
            for (int i = 0; i < c; i++) {
                if (cave[n - 1][i] == 1) {
                    cave[n - 1][i] = 0;
                    break;
                }
            }
        }
        //짝수 회차일때 오른쪽 첫번째 미네랄을 삭제
        else {
            for (int i = c - 1; i >= 0; i--) {
                if (cave[n - 1][i] == 1) {
                    cave[n - 1][i] = 0;
                    break;
                }
            }
        }
    }

    // 클러스터를 찾음
    // 클러스터는 바닥과 맞닿아있는 것들을 제외하면 하나뿐이다.

    static void findCluster() {
        for (int i = 0; i < r; i++) Arrays.fill(visit[i], 0);
        // 바닥에 붙어있는 미네랄들의 좌표를 큐에 넣음
        for (int i = 0; i < c; i++) {
            if (cave[0][i] == 1) {
                visit[0][i] = 1;
                queue.add(new int[]{0, i});
            }
        }
        while (!queue.isEmpty()) {
            // 큐에서 하나씩 빼가며 BFS를 통해 붙어있는 미네랄을 찾음
            int[] tmp = queue.remove();
            for (int i = 0; i < 4; i++) {
                int y = tmp[0] + dy[i];
                int x = tmp[1] + dx[i];
                // 범위를 벗어남
                if (y < 0 || y >= r || x < 0 || x >= c) continue;
                if (visit[y][x] == 0 && cave[y][x] == 1) {
                    // 주변 4칸이 미네랄이고 탐색한 적이 없다면 탐색후보 큐에 넣음
                    visit[y][x] = 1;
                    queue.add(new int[]{y, x});
                }
            }
        }
    }

    static void dropCluster() {
        int height = r;

        for (int i = 0; i < c; i++) {
            int top = -1;
            int bottom = -1;
            for (int j = 0; j < r; j++) {
                if (cave[j][i] == 0) continue;
                if (visit[j][i] == 1) {
                    bottom = j;
                } else {
                    top = j;
                    break;
                }
            }
            if (top - bottom - 1 >= 0) height = Math.min(height, top - bottom - 1);
        }


        if (height > 0) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (cave[i][j] == 1 && visit[i][j] == 0) {
                        cave[i][j] = 0;
                        cave[i - height][j] = 1;
                    }
                }
            }
        }
    }

    static int[][] cave;
    static int[][] visit;
    static int c;
    static int r;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        cave = new int[r][c];
        visit = new int[r][c];
        int count = 1;

        //초기 미네랄 상태
        for (int i = r - 1; i >= 0; i--) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                char ch = row.charAt(j);
                if (ch == 'x') {
                    cave[i][j] = 1;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            throwStick(Integer.parseInt(st.nextToken()), count);
            findCluster();

            dropCluster();
            count++;
        }

        for (int i = r - 1; i >= 0; i--) {
            for (int j = 0; j < c; j++) {
                if (cave[i][j] == 0) {
                    sb.append(".");
                } else {
                    sb.append("x");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}
