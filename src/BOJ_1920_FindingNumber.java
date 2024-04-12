import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_1920_FindingNumber {
    static int[] arr;

    public static int binarySearch(int value, int low, int high) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if(arr[mid] == value) {
                return 1;
            } else if(arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(value, 0, N-1));
        }

    }
}