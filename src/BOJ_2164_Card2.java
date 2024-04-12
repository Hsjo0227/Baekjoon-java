import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_Card2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            int num = queue.poll();
            queue.offer(num);
        }

        System.out.println(queue.poll());

    }
}