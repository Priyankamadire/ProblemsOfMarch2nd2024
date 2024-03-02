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

/*Brute force approach
 * step 1 create the permunations and store in list
* step 2 check if those permunations are present in those substrings
 */
import java.util.*;

public class BruteForceFindAnagram {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String w = sc.nextLine();
        String k = sc.next();
        ArrayList<String> al = listofpermutations(k);
        System.out.print(findanagrams(al, w));

    }

    public static int findanagrams(ArrayList<String> al, String w) {
        int n = al.get(0).length();
        int count = 0;
        HashSet<String> hs = new HashSet<>(al);
        for (int i = 0; i <= w.length() - n; i++) {   //loop is less than or equal to main str length minus current length of string 
            String sub = w.substring(i, i + n);
            if (hs.contains(sub)) {
                count++;
            }
        }
        return count;
    }

    public static void permunations(String s, StringBuilder sb, ArrayList<String> al) {
        if (s.length() == sb.length()) {
            al.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.indexOf(String.valueOf(c)) != -1) {
                continue;
            }
            sb.append(c);
            permunations(s, sb, al);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static ArrayList<String> listofpermutations(String s) {
        ArrayList<String> r = new ArrayList<>();
        permunations(s, new StringBuilder(), r);
        System.err.println(r);
        return r;
    }
}