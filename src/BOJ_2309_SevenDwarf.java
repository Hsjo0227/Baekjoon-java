import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2309번 - 일곱 난쟁이
public class BOJ_2309_SevenDwarf {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfs = new int[9];
        int stranger1 = -1;
        int stranger2 = -1;
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            sum += height;
            dwarfs[i] = height;
        }

        Arrays.sort(dwarfs);

        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - dwarfs[i] - dwarfs[j] == 100) {
                    stranger1 = i;
                    stranger2 = j;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if(i!=stranger1 && i!=stranger2){
                System.out.println(dwarfs[i]);
            }
        }
    }
}
