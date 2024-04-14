import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
    public static int function(int length, int r, int c) {
        if(length == 1) return 0;
        int half = length/2;

        if(r <= half && c <= half) return function(half, r, c);
        else if(r <= half && c > half) return function(half, r, c - half) + half * half;
        else if(r > half && c <= half) return function(half, r - half, c) + half * half * 2;
        else return function(half, r - half, c -half) + half * half * 3;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int length = (int)Math.pow(2, N);

        int answer = function(length, r + 1, c + 1);

        System.out.println(answer);

    }
}