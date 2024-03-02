
/*Count Occurences of Anagrams
MediumAccuracy: 48.09%Submissions: 69K+Points: 4
Internship Alert
New month-> Fresh Chance to top the leaderboard and get SDE Internship! 

banner
Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.

Example 1:

Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.
Example 2:

Input:
txt = aabaabaa
pat = aaba
Output: 4
Explanation: aaba is present 4 times
in txt.
Your Task:
Complete the function search() which takes two strings pat, txt, as input parameters and returns an integer denoting the answer. 
You don't need to print answer or take inputs.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(26) or O(256)

Constraints:
1 <= |pat| <= |txt| <= 105
Both strings contain lowercase English letters.

 */
import java.util.*;
import java.io.*;

public class SlidingWindowFindAnagram {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String w = sc.nextLine();
        String k = sc.next();
        System.out.print(findanagrams(w, k));

    }

    public static int findanagrams(String w, String k) {
        int n = w.length();
        int m = k.length();
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            char c = k.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int cnt = map.size();
        int i = 0, j = 0;
        while (j < n) {
            char ch = w.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    cnt--;
                }
            }
            if (j - i + 1 < m) {
                j++;
            } else if (j - i + 1 == m) {
                if (cnt == 0) {
                    al.add(i);
                }
                char p = w.charAt(i);
                if (map.containsKey(p)) {
                    map.put(p, map.get(p) + 1);
                    if (map.get(p) == 1) {
                        cnt++;
                    }
                }
                i++;
                j++;
            }
        }
        return al.size();
    }
}