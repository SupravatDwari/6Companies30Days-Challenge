/* Leetcode Link : https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/ */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getAllNodes(root1);
        List<Integer> list2 = getAllNodes(root2);
        List<Integer> merged = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);
        Collections.sort(merged);
        return merged;
    }

    private List<Integer> getAllNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return inorder(root, list);
    }

    private List<Integer> inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        inorder(root.left, result);
        result.add(root.val);
        return inorder(root.right, result);
    }
}

/* Submission Link : https://leetcode.com/problems/all-elements-in-two-binary-search-trees/submissions/875862837/ */
