import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051_NumberSquare {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int answer = 1;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min = Math.min(N, M);

        int[][] board = new int[N][M];


        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                for(int k=0; k<min; k++) {
                    if((i+k)>=N || (j+k)>=M) break;
                    if(board[i][j]==board[i+k][j] &&
                            board[i][j]==board[i][j+k] &&
                            board[i][j]==board[i+k][j+k]){
                        answer = Math.max(k+1, answer);
                    }

                }
            }
        }
        System.out.println(answer*answer);
    }
}
