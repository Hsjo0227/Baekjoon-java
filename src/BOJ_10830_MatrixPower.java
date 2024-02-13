import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10830번 - 행렬 제곱
public class BOJ_10830_MatrixPower {
    static int n;
    private static int[][] multi(int[][] m1, int[][] m2){
        int[][] result = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                    result[i][j] %= 1000;
                }

            }

        }
        return result;
    }
    
    private static int[][] powerMatrix(int[][] A, long exp) {
        if (exp == 1) {
            return A;
        } else {
            // 행렬 A^exp를 {A^(exp/2)} * {A^(exp/2)} (지수가 홀수라면 * A)로 계산한다.
            int[][] half = powerMatrix(A, exp / 2);
            int[][] result = multi(half, half);
            
            
            //홀수면 A를 곱해준다.
            if(exp%2!=0){
                result = multi(result, A);
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int[][] A = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        
        int[][] result = powerMatrix(A, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", result[i][j]);
            }
            System.out.println();
        }


    }
}
