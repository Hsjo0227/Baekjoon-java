import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1003_FiboFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        list.add(new int[] {1, 0});
        list.add(new int[] {0, 1});

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int size = list.size();
            while(N >= size){
                int[] next = new int[2];
                next[0] = list.get(size-1)[0] + list.get(size-2)[0];
                next[1] = list.get(size-1)[1] + list.get(size-2)[1];
                list.add(next);
                size++;
            }
            int[] answer = list.get(N);
            System.out.println(answer[0] + " " + answer[1]);
        }
    }
}
