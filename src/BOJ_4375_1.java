import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 4375번 - 1
public class BOJ_4375_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 1;
        int allOne = 1;
        String input = "";

        while ((input = br.readLine()) != null) {
            answer = 1;
            allOne = 1;
            int n = Integer.parseInt(input);
            while (true) {
                if (allOne % n == 0) {
                    break;
                } else {
                    allOne = allOne * 10 + 1;
                    allOne %= n;
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}
