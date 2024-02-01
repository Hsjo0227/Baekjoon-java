import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1655_SayMiddle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        //maxheap에는 작은 수 절반, minheap에는 큰 수 절반을 저장함
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            if(maxHeap.size() == minHeap.size()){
                maxHeap.add(m);
            } else if(maxHeap.size() > minHeap.size()) {
                minHeap.add(m);
            }

            if(!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek()>minHeap.peek()){
                int tmp = maxHeap.poll();
                maxHeap.add(minHeap.poll());
                minHeap.add(tmp);
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
