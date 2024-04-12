import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_GcdAndLcm {

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    int a = Math.max(A, B);
    int b = Math.min(A, B);

    while (b != 0){
        int r = a % b;
        a = b;
        b = r;
    }
    int gcd = a;
    int lcm = A * B / gcd;

    System.out.println(gcd);
    System.out.println(lcm);
}
}
