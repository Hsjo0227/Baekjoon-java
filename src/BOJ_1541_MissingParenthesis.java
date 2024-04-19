import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1541_MissingParenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int answer = 0;
        int i = 0;
        while(st.hasMoreTokens()) {
            String expression = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(expression, "+");

            int number = 0;
            while(st2.hasMoreTokens()) {
                number += Integer.parseInt(st2.nextToken());
            }

            if(i==0) {
                answer += number;
            } else {
                answer -= number;
            }
            i++;
        }
        System.out.println(answer);
    }
}