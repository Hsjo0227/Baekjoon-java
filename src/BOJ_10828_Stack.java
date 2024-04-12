import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10828_Stack {
    public static int[] stack;
    public static int size = 0;

    public static void push (int a) {
        stack[size] = a;
        size++;
    }

    public static int pop () {
        if (size <= 0) return -1;
        size--;
        return stack[size];
    }

    public static int size () {
        return size;
    }

    public static int empty () {
        return (size == 0) ? 1 : 0;
    }

    public static int top () {
        if(size == 0) return - 1;
        return stack[size - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stack = new int[N];

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

                case "top":
                    System.out.println(top());
                    break;
            }
        }
    }
}