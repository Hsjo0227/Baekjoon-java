import java.io.*;
import java.util.*;

public class BOJ_3197_SwanLake {
    static int r;
    static int c;
    static int[] parent;

    // 이차원 호수를 각 칸마다 번호를 부여한다.(1차원 배열 처럼)
    static int convert1D(int x, int y) {
        return x*c+y;
    }
    static int[] convert2D(int idx){
        int x = idx/c;
        int y = idx%c;
        return new int[]{x, y};
    }

    // 자신이 속한 물 공간의 루트노드를 찾는다
    static int find(int num) {
        if (parent[num] >= 0) {
            return parent[num] = find(parent[num]);
        } else {
            return num;
        }
    }


    // 각 노드의 부모는 왼쪽, 위쪽, 아래쪽, 오른쪽 순서대로 탐색하여 인접한 물 공간이다.
    static void union(int n1, int n2) {
        n1 = find(n1);
        n2 = find(n2);
        if (n1 == n2) {
            return;
        }
        if (n1 < n2) {
            parent[n2] = n1;
        } else {
            parent[n1] = n2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 물 공간을 BFS로 처리하기 위해서 큐가 필요함
        Queue<int[]> queue = new ArrayDeque<>();

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // parent: 부모노드의 번호를 표시함
        // stateList: 얼음이 몇일차에 녹았는지 표시
        parent = new int[r * c];
        Arrays.fill(parent, -1);
        int[][] stateList = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(stateList[i], -1);
        }
        int[] swans = new int[2];
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int count = 0;

        //처음 호수의 상태를 저장
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = s.charAt(j);
                if (c != 'X') {
                    stateList[i][j] = 0;
                }
                if (c == 'L') {
                    swans[count++] = convert1D(i, j);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 빙판 공간이면 패스
                if(stateList[i][j]<0){continue;}

                // 좌, 상, 하, 우를 순서대로 탐색하여
                boolean adjacent = false;
                for (int k = 0; k < 4; k++) {
                    int x = i+dx[k];
                    int y = j+dy[k];
                    if(x<0 || x>=r || y<0 || y>=c) continue;

                    // 빙판 공간과 인접했다면 큐에 집어넣음
                    if(stateList[x][y]<0){adjacent=true;}
                    // 주변이 물 공간이라면 부모관계 생성
                    else{
                        union(convert1D(i, j), convert1D(x, y));
                    }
                }
                if(adjacent) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        // 백조가 같은 물 공간 집합내에 있는지 확인
        if(find(swans[0])==find(swans[1])){
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {

            // 큐에서 하나씩 빼서 주변의 칸을 물 공간으로 바꾸고 부모 노드를 설정하고 큐에 넣음
            int[] pos = queue.remove();
            int x = pos[0];
            int y = pos[1];
            int date = pos[2];
            for (int j = 0; j < 4; j++) {
                int nx = x+dx[j];
                int ny = y+dy[j];
                if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
                if (stateList[nx][ny]<0){
                    queue.add(new int[]{nx, ny, date+1});
                    stateList[nx][ny] = date+1;
                }
                union(convert1D(x, y),convert1D(nx, ny));
                // 백조가 같은 물 공간 집합내에 있다면 정답임
                if(find(swans[0])==find(swans[1])){
                    System.out.println(stateList[nx][ny]);
                    return;
                }
            }
        }
    }
}
