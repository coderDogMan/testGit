package work;


//
/*
* 你有一个数组长度A, 0 <= n <= 60, 0 <= A[i] <= 4
* 每次你可以选择两种操作
* 操作1， 选择连续的三个下标对其对应的值减1（把A[i - 2],A[i - 1],A[i] | A[i - 1],A[i],A[i + 1] | A[i],A[i + 1],A[i + 2] 都减1）
* 操作2， 选择一个下标把对应的值减3
* 同时你可以对数组任何一次下标进行k次+1 (0 <= k <= 4)
* 请问可以使用操作1和操作2把数组中的所有值变成0吗
* */


import java.util.HashMap;
import java.util.Scanner;

public class ShunKe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        byte[] cnt = new byte[60];
        for (int i = 0; i < n; i++) {
            cnt[in.nextInt()]++;
        }
        if ((n + k) % 3 != 0) {
            System.out.println(false);
        } else {
            System.out.println(dfs(cnt, n, k));
        }

    }

    private static boolean dfs(byte[] cnt, int n, int k) {
        if (k < 0) return false;
        if (n == 0 && k == 0) return true;
        for (int i = 0; i < 60; i++) {
            if (cnt[i] == 0) continue;
            // 消除当前3个
            if (cnt[i] >= 3) {
                cnt[i] -= 3;
                if (dfs(cnt, n - 3, k)) return true;
                cnt[i] += 3;
            } else {
                byte num = cnt[i];
                cnt[i] = 0;
                if (dfs(cnt, n - num, k - (3 - num))) return true;
                cnt[i] = num;
            }
            // 消除 当前一个 右边一个 癞子一个
            if (i % 10 < 9 && i < 40) {
                if (cnt[i + 1] >= 1) {
                    cnt[i + 1] -= 1;
                    cnt[i] -= 1;
                    if (dfs(cnt, n - 2, k - 1)) return true;
                    cnt[i] += 1;
                    cnt[i + 1] += 1;
                } else {
                    cnt[i] -= 1;
                    if (dfs(cnt, n - 1, k - 2)) return true;
                    cnt[i] += 1;
                }
            }
            //消除 当前一个 右边一个 右边的右边一个
            if (i % 10 < 8 && i < 40) {
                if (cnt[i + 1] >= 1 && cnt[i + 2] >= 1) {
                    cnt[i + 2] -= 1;
                    cnt[i + 1] -= 1;
                    cnt[i] -= 1;
                    if (dfs(cnt, n - 3, k)) return true;
                    cnt[i + 2] += 1;
                    cnt[i + 1] += 1;
                    cnt[i] += 1;
                } else if (cnt[i + 2] < 1 && cnt[i + 1] < 1) {
                    cnt[i] -= 1;
                    if (dfs(cnt, n - 1, k - 2)) return true;
                    cnt[i] += 1;
                } else if (cnt[i + 2] < 1) {
                    cnt[i + 1] -= 1;
                    cnt[i] -= 1;
                    if (dfs(cnt, n - 2, k - 1)) return true;
                    cnt[i] += 1;
                    cnt[i + 1] += 1;
                } else if (cnt[i + 1] < 1) {
                    cnt[i + 2] -= 1;
                    cnt[i] -= 1;
                    if (dfs(cnt, n - 2, k - 1)) return true;
                    cnt[i] += 1;
                    cnt[i + 2] += 1;
                }
            }
        }
        return false;
    }
}
