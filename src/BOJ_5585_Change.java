import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5585번 - 거스름돈
public class BOJ_5585_Change {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        money = 1000 - money;
        int result = 0;

        while (money > 0) {
            if (money < 5) {
                result += money;
                money = 0;
                break;
            }
            if (money < 10) {
                result++;
                money -= 5;
                continue;
            }
            if (money < 50) {
                result++;
                money -= 10;
                continue;
            }
            if (money < 100) {
                result++;
                money -= 50;
                continue;
            }
            if (money < 500) {
                result++;
                money -= 100;
                continue;
            }
            result++;
            money -= 500;
        }
        System.out.println(result);
    }
}
