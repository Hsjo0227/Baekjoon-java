import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10866_Deque {
        public static int[] deque;
        public static int N;
        public static int front = 0;
        public static int rear = 0;

        public static void push_front (int a) {
            deque[front] = a;
            front = (front - 1 + N) % N;
        }

        public static void push_back (int a) {
            rear = (rear + 1) % N;
            deque[rear] = a;
        }

        public static int pop_front () {
            if (front == rear) return -1;
            front = (front + 1) % N;
            return deque[front];
        }

        public static int pop_back () {
            if (front == rear) return -1;
            int result = deque[rear];
            rear = (rear - 1 + N) % N;
            return result;
        }

        public static int size () {
            return (rear - front + N) % N;
        }

        public static int empty () {
            return (rear == front) ? 1 : 0;
        }

        public static int front () {
            if(rear == front) return - 1;
            return deque[(front + 1) % N];
        }

        public static int back () {
            if(rear == front) return - 1;
            return deque[rear];
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            deque = new int[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String instruction = st.nextToken();

                switch(instruction) {
                    case "push_front":
                        int a = Integer.parseInt(st.nextToken());
                        push_front(a);
                        break;

                    case "push_back":
                        int b = Integer.parseInt(st.nextToken());
                        push_back(b);
                        break;

                    case "pop_front":
                        System.out.println(pop_front());
                        break;

                    case "pop_back":
                        System.out.println(pop_back());
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