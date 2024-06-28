import java.io.*;
import java.util.*;

// 추측 문제 유형 : dp , 실제 문제 유형 : dp
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] grapes = new int[n];

        for (int i = 0; i < n; i++) {
            grapes[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.print(grapes[0]);
            return;
        }
        //2번째 잔일 경우 dp[n][1] 에 넣기, 0은 안마신거 , 1은 첫 잔, 2는 두번째 잔
        int[][] dp = new int[n][3];
        dp[0][1] = grapes[0];
        dp[1][0] = grapes[0];
        dp[1][1] = grapes[1];
        dp[1][2] = grapes[0] + grapes[1];

        int answer = -1;

        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][1] = dp[i - 1][0] + grapes[i];
            dp[i][2] = dp[i - 1][1] + grapes[i];
        }

        for (int i = n - 2; i < n; i++) {
            answer = Math.max(dp[i][0], answer);
            answer = Math.max(dp[i][1], answer);
            answer = Math.max(dp[i][2], answer);
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.print(answer);
    }
}