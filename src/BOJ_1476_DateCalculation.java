import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1476번 - 날짜 계산
public class BOJ_1476_DateCalculation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] date = new int[3];
        int[] bound = {15, 28, 19};
        int count = 1;

        for (int i = 0; i < 3; i++) {
            date[i] = Integer.parseInt(st.nextToken());
        }


        while (!Arrays.equals(date, new int[]{1, 1, 1})) {
            for (int i = 0; i < 3; i++) {
                date[i]--;
            }
            for (int i = 0; i < 3; i++) {
                if (date[i] < 1) {
                    date[i] = bound[i];
                }
            }
            count++;
        }

        System.out.println(count);


    }
}
