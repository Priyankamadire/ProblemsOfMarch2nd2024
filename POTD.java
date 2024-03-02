
/*977. Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
import java.util.*;

public class POTD {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(Arrays.toString(sortedSquares(n, arr)));
    }

    public static int[] sortedSquares(int n, int[] nums) {
        int[] arr = new int[n];
        int i = 0;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int ls = power(nums[l], 2);
            int rs = power(nums[r], 2);
            if (ls > rs) {
                arr[i++] = ls;
                l++;
            } else {
                arr[i++] = rs;
                r--;
            }
        }
        Arrays.sort(arr);
        return arr;
    }

    public static int power(int n, int p) {
        if (p == 0) {
            return 1;
        }
        int k = power(n, p / 2);
        if (p % 2 == 0) {
            return k * k;
        }
        return n * k * k;
    }
}