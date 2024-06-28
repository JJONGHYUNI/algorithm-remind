import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, cnt, idx;
    static char[] chars;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        chars = br.readLine().toCharArray();

        idx = 0;
        cnt = 0;
        int cur = 0;
        while (idx < m - 2) {
            if (chars[idx] == 'I') {
                if (check()) {
                    cur += 1;
                    idx += 2;

                    if (cur == n) {
                        cnt += 1;
                        cur -= 1;
                    }
                    continue;
                }
            }
            idx += 1;
            cur = 0;
        }

        System.out.print(cnt);
    }

    private static boolean check() {
        for (int i = idx + 1; i < idx + 3; i++) {
            if (i == idx + 1 && chars[i] == 'O') {
                continue;
            } else if (i == idx + 2 && chars[i] == 'I') {
                continue;
            }
            return false;
        }
        return true;
    }
}