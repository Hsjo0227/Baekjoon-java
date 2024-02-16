import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2109번 - 순회강연
public class BOJ_2109_TouringLecture {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] lectures = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        // 날짜는 오름차순, 강연료는 내림차순
        Arrays.sort(lectures, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) return arr1[1] - arr2[1];
            else return arr2[0] - arr1[0];
        });

        // 강연료가 비싼 것부터 가능한 날에 끼워넣음
        int[] pay = new int[10001];
        for (int i = 0; i < n; i++) {
            for (int j = lectures[i][1]; j >= 1; j--) {
                if (pay[j] == 0) {
                    pay[j] = lectures[i][0];
                    break;
                }
            }
        }

        int result=0;
        for (int i = 1; i < 10001; i++) {
            result += pay[i];
        }
        System.out.println(result);
    }
}
