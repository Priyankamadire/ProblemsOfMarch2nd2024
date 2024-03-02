
/*Experiment - 2 */
import java.util.*;

public class DietPlainSlidingWindow {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int l = sc.nextInt();
        int u = sc.nextInt();
        System.out.print(slidingWindowsolve(n, m, arr, l, u));
    }

    public static int slidingWindowsolve(int n, int k, int arr[], int l, int u) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = 0;

        while (j < n) {
            sum += arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (sum < l) {
                    ans--;
                } else {
                    ans++;
                }
                i++;
                j++;
            }

        }
        return ans;
    }

    public static int bruteforcesolve(int n, int k, int arr[], int l, int u) {
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> bl = new ArrayList<>();
        int sum1 = 0;
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            al.add(sum);
        }
        for (int i = 0; i <= n - k; i++) {
            if (al.get(i) < l) {
                bl.add(-1);

            } else {
                bl.add(1);
            }
        }
        System.out.print(bl);
        for (int i = 0; i < n - k + 1; i++) {
            sum1 += bl.get(i);
        }
        return sum1;
    }
}