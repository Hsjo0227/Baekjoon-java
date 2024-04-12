import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9012_Parenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String answer = "";

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int count = 0;
            answer = "YES";
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') count++;
                else if (str.charAt(j) == ')') count--;

                if (count < 0) {
                    answer = "NO";
                    break;
                }
            }
            if (count != 0) {
                answer = "NO";
            }
            System.out.println(answer);
        }
    }
}
