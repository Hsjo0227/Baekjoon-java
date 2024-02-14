import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1080번 - 행렬
public class BOJ_1080_Matrix {
    static int[][] matrixDifference;
    private static int N;
    private static int M;

    static void reverse(int x, int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrixDifference[x + i][y + j] == 0) matrixDifference[x + i][y + j] = 1;
                else matrixDifference[x + i][y + j] = 0;
            }
        }
    }

    static int search() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrixDifference[i][j] == 0) continue;
                count++;
                try {
                    reverse(i, j);
                } catch (Exception e) {
                    return -1;
                }
                i = 0;
                j = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] matrixA = new int[N][M];
        int[][] matrixB = new int[N][M];
        matrixDifference = new int[N][M];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                matrixA[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                matrixB[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrixDifference[i][j] = Math.abs(matrixB[i][j] - matrixA[i][j]);
            }
        }

        if (N < 3 || M < 3) {
            if (!Arrays.deepEquals(matrixB, matrixA)) answer = -1;
        } else {
            answer = search();
        }

        System.out.println(answer);


    }
}
