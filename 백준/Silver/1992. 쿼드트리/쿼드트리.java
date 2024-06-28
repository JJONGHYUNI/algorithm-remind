import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        String s;

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        quadTree(0, 0, n);
        System.out.print(answer);
    }

    private static void quadTree(int y, int x, int n) {
        int tmp = arr[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (tmp != arr[i][j]) {
                    answer.append("(");
                    quadTree(y, x, n / 2);
                    quadTree(y, x + n / 2, n / 2);
                    quadTree(y + n / 2, x, n / 2);
                    quadTree(y + n / 2, x + n / 2, n / 2);
                    answer.append(")");
                    return;
                }
            }
        }

        if (tmp == 0) {
            answer.append("0");
            return;
        }
        answer.append("1");
    }
}