import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10845_Queue {
    public static int[] queue;
    public static int front = 0;
    public static int rear = 0;

    public static void push (int a) {
        queue[rear] = a;
        rear++;
    }

    public static int pop () {
        if (front == rear) return -1;
        int result = queue[front];
        front++;
        return result;
    }

    public static int size () {
        return rear-front;
    }

    public static int empty () {
        return (rear == front) ? 1 : 0;
    }

    public static int front () {
        if(rear == front) return - 1;
        return queue[front];
    }

    public static int back () {
        if(rear == front) return - 1;
        return queue[rear - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        queue = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String instruction = st.nextToken();

            switch(instruction) {
                case "push":
                    int a = Integer.parseInt(st.nextToken());
                    push(a);
                    break;

                case "pop":
                    System.out.println(pop());
                    break;

                case "size":
                    System.out.println(size());
                    break;

                case "empty":
                    System.out.println(empty());
                    break;

                case "front":
                    System.out.println(front());
                    break;

                case "back":
                    System.out.println(back());
                    break;
            }
        }
    }
}