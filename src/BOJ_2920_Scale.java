import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2920_Scale {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        boolean ascending = true;
        boolean descending =  true;
        String answer;
        int[] numbers = new int[8];
        for (int i = 0; i < 8; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 8; i++) {
            if(numbers[i] != numbers[i-1] + 1) ascending = false;
            if(numbers[i] != numbers[i-1] - 1) descending = false;
        }

        if(ascending == true) answer = "ascending";
        else if(descending == true) answer = "descending";
        else answer = "mixed";

        System.out.println(answer);
    }
}