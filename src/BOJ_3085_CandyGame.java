import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3085번 - 사탕 게임
public class BOJ_3085_CandyGame {
    static int max = 1;
    static int n;
    static char[][] arr;

    public static void search() {
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                char tmp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = tmp;
                search();
                arr[i][j + 1] = arr[i][j];
                arr[i][j] = tmp;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                char tmp = arr[i][j];
                arr[i][j] = arr[i + 1][j];
                arr[i + 1][j] = tmp;
                search();
                arr[i + 1][j] = arr[i][j];
                arr[i][j] = tmp;
            }
        }

        System.out.println(max);
    }
}
