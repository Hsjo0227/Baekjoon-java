import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8958_OXQuiz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String result = br.readLine();
            int count = 0;
            int point = 0;
            for(int j = 0; j < result.length(); j++) {
                if(result.charAt(j)=='X') count = 0;
                else if(result.charAt(j)=='O') count++;
                point += count;
            }
            System.out.println(point);
        }
    }
}