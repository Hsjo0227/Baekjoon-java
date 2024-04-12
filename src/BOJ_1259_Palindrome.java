import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259_Palindrome {
    public static boolean isPalindrome (String str) {
        int size = str.length();
        for (int i = 0; i < size/2; i++) {
            if(str.charAt(i) != str.charAt(size - i - 1)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        while(!str.equals("0")) {
            System.out.println(isPalindrome(str) ? "yes" : "no");
            str = br.readLine();
        }
    }
}
