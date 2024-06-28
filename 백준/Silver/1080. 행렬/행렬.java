import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] a, b;
    static int n, m, ans;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        b = new int[n][m];
        String s;

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (a[i][j] != b[i][j]) {
                    change(i, j);
                    ans++;
                }
            }
        }
        if (check()) {
            System.out.print(ans);
        } else {
            System.out.print(-1);
        }

    }

    private static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void change(int y, int x) {
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                a[i][j] = 1 - a[i][j];
            }
        }
    }
}