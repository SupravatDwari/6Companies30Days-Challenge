/* Leetcode Link : https://leetcode.com/problems/maximum-good-people-based-on-statements/description/ */

public class Solution {
    public int maximumGood(int[][] statements) {
        int[] known = new int[statements.length];
        Arrays.fill(known, 2);
        return max(statements, known, 0);
    }

    private int max(int[][] statements, int[] known, int position) {
        if (position == statements.length) {
            return (int) Arrays.stream(known).filter(a -> a == 1).count();
        }
        switch (known[position]) {
            case 0:
                return assumeBad(statements, known, position);
            case 1:
                return assumeGood(statements, known, position);
            default:
                return Math.max(
                        assumeBad(statements, known, position),
                        assumeGood(statements, known, position));
        }
    }

    private int assumeBad(int[][] statements, int[] known, int position) {
        int[] updatedKnown = known.clone();
        updatedKnown[position] = 0;
        return max(statements, updatedKnown, position + 1);
    }

    private int assumeGood(int[][] statements, int[] known, int position) {
        int[] updatedKnown = known.clone();
        boolean conflictDetected = false;
        updatedKnown[position] = 1;
        for (int i = 0; i < statements[position].length; i++) {
            int answer = statements[position][i];
            if (answer != 2) {
                if (known[i] != 2 && answer != known[i]) {
                    conflictDetected = true;
                    break;
                }
                updatedKnown[i] = answer;
            }
        }
        return conflictDetected ? 0 : max(statements, updatedKnown, position + 1);
    }
}

/* Submission Link : https://leetcode.com/problems/maximum-good-people-based-on-statements/submissions/875864463/ */
