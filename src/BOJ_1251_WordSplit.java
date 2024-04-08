import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class BOJ_1251_WordSplit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = new ArrayList<>();
        String word = br.readLine();

        for (int i = 1; i < word.length(); i++) {
            for (int j = 1; j < i; j++) {

                StringBuilder sb = new StringBuilder();
                StringBuilder word1 = new StringBuilder(word.substring(0, j));
                StringBuilder word2 = new StringBuilder(word.substring(j, i));
                StringBuilder word3 = new StringBuilder(word.substring(i));

                sb.append(word1.reverse().append(word2.reverse().append(word3.reverse())));
                words.add(sb.toString());
            }
        }

        Collections.sort(words);

        System.out.println(words.get(0));
    }
}
