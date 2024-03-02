import java.util.*;

public class MaxiumElementinSubarray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(bruteforce(n, m, arr));
        System.out.print(slidingWindowsolve(n, m, arr));

    }

    public static ArrayList<Integer> slidingWindowsolve(int n, int k, int arr[]) {
        int i = 0;
        int j = 0;
        int maxi = Integer.MIN_VALUE;
        ArrayList<Integer> al = new ArrayList<>();
        while (j < n) {
            maxi = Math.max(maxi, arr[j]);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                al.add(maxi);
                i++;
                j++;
            }
        }
        return al;
    }

    public static ArrayList<Integer> bruteforce(int n, int k, int arr[]) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i <= n - k; i++) {
            int maxi = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                maxi = Math.max(maxi, arr[j]);
            }
            al.add(maxi);
        }
        return al;

    }
}