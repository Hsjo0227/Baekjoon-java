import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 2747번 - 피보나치 수
public class BOJ_2747_Fibo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(1);

        for (int i = 0; i < n; i++) {
            int f_0 = queue.remove();
            int f_1 = queue.peek();
            int f_n = (f_1 + f_0);
            queue.add(f_n);
        }
        System.out.println(queue.remove());
    }
}
