package multiply;

/**
 * 解题思路: 谁大减谁
 *
 * @author: itsuki
 * @create: 2021-04-26 20:33
 **/
public class Solution {
    public int multiply(int A, int B) {
        if (A == 0 || B == 0) return 0;

        if (A < B) {
            return multiply(A - 1, B) + B;
        }

        return multiply(A, B - 1) + A;
    }
}
