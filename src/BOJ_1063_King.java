import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1063_King {
    static int[] kingPos = new int[2];
    static int[] stonePos = new int[2];

    static Map<String, int[]> dirs = new HashMap<>();

    public static void moveKing(String dirStr) {
        int[] dir = dirs.get(dirStr);
        int[] nextKingPos = new int[2];
        int[] nextStonePos = new int[2];
        for(int i=0; i<2; i++) {
            nextKingPos[i] = kingPos[i] + dir[i];
            if(!checkBoundary(nextKingPos[i])) return;
        }
        if(!Arrays.equals(nextKingPos, stonePos)) {
            kingPos = Arrays.copyOf(nextKingPos, 2);
            return;
        }
        for(int i=0; i<2; i++) {
            nextStonePos[i] = stonePos[i] + dir[i];
            if(!checkBoundary(nextStonePos[i])) return;
        }
        kingPos = Arrays.copyOf(nextKingPos, 2);
        stonePos = Arrays.copyOf(nextStonePos, 2);
    }
    public static boolean checkBoundary(int pos) {
        return pos <= 8 && pos >= 1;
    }
    public static void main(String[] args) throws IOException{
        dirs.put("R",new int[]{1,0});
        dirs.put("L",new int[]{-1,0});
        dirs.put("B",new int[]{0,-1});
        dirs.put("T",new int[]{0,1});
        dirs.put("RT",new int[]{1,1});
        dirs.put("LT",new int[]{-1,1});
        dirs.put("RB",new int[]{1,-1});
        dirs.put("LB",new int[]{-1,-1});

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String kingPosStr = st.nextToken();
        String stonePosStr = st.nextToken();


        kingPos[0] = kingPosStr.charAt(0) - 'A' + 1;
        kingPos[1] = kingPosStr.charAt(1) - '0';

        stonePos[0] = stonePosStr.charAt(0) - 'A' + 1;
        stonePos[1] = stonePosStr.charAt(1) - '0';

        int N = Integer.parseInt(st.nextToken());


        for(int i=0; i<N; i++) {
            String dirStr = br.readLine();
            moveKing(dirStr);
        }

        StringBuilder sb = new StringBuilder();
        sb.append((char)(kingPos[0] + 'A' - 1));
        sb.append(Character.forDigit(kingPos[1],10));
        sb.append("\n");
        sb.append((char)(stonePos[0] + 'A' - 1));
        sb.append(Character.forDigit(stonePos[1],10));

        System.out.println(sb);
    }
}
