import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18185_BuyingRamen {
    static int[] factories;
    static int result;

    static void buy1(int idx) {
        int num = factories[idx];
        factories[idx] = 0;
        result += num * 3;
    }

    static void buy2(int idx, int num) {
        factories[idx] -= num;
        factories[idx + 1] -= num;
        result += num * 5;
    }

    static void buy3(int idx, int num) {
        factories[idx] -= num;
        factories[idx + 1] -= num;
        factories[idx + 2] -= num;
        result += num * 7;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        factories = new int[n + 2];
        for (int i = 0; i < n; i++) {
            factories[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (factories[i + 1] > factories[i + 2]) {
                int min = Math.min(factories[i], factories[i + 1] - factories[i + 2]);
                buy2(i, min);
                min = Math.min(factories[i], factories[i + 1]);
                buy3(i, min);
            } else {
                int min = Math.min(factories[i], factories[i + 1]);
                buy3(i, min);
                min = Math.min(factories[i], factories[i + 1]);
                buy2(i, min);
            }
            buy1(i);
        }
        System.out.println(result);
    }
}
