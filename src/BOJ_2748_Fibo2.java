import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2748_Fibo2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Long> queue = new LinkedList<>();
        queue.add(0L);
        queue.add(1L);

        for (int i = 0; i < n; i++) {
            long f_0 = queue.remove();
            long f_1 = queue.peek();
            long f_n = (f_1 + f_0);
            queue.add(f_n);
        }
        System.out.println(queue.remove());
    }
}
