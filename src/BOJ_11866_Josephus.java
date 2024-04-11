import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11866_Josephus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N + 1; i++) {
            list.add(i);
        }

        int idx = 0;
        sb.append("<");
        for(int i = 0; i < N - 1; i++) {
            idx = idx + K - 1;
            idx = idx % list.size();
            Integer value = list.remove(idx);
            sb.append(value + ", ");
        }
        sb.append(list.remove(0)+">");

        System.out.println(sb);
    }
}