import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 12015번 - 가장 긴 증가하는 부분 수열 2
public class BOJ_12015_LIS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();

        lis.add(A[0]);

        for (int i = 1; i < N; i++) {
            int value = A[i];
            int left = 0;
            int right = lis.size() - 1;

            if(value > lis.get(right)) lis.add(value);
            else {

                while(left < right) {
                    int mid = (left + right) / 2;
                    if(lis.get(mid) < value) left = mid + 1;
                    else if(lis.get(mid) >= value) right = mid;
                }
                lis.set(left, value);
            }
        }
        System.out.println(lis.size());
    }
}
