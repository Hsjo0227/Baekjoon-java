import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053_LIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] A = new int[N];
        int[] length = new int[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        length[0] = 1;
        for (int i = 1; i < N; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if(A[i] > A[j]){
                    max = Math.max(length[j]+1, max);
                }
            }
            length[i] = max;
        }

        result = Arrays.stream(length).max().getAsInt();

        System.out.println(result);

    }
}
