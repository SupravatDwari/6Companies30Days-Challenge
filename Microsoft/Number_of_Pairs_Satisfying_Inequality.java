/* Leetcode Link : https://leetcode.com/problems/number-of-pairs-satisfying-inequality/description/ */

class Solution {
  int query(int[] tree, int index) {
    int ans = 0;
    index++;

    while (index > 0) {
      ans += tree[index];
      index -= index & (-index);
    }
    return ans;
  }

  void update(int[] tree, int index, int size) {
    index++;
    while (index <= size) {
      tree[index] += 1;
      index += index & (-index);
    }
  }

  public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
    int shift = 20000;
    int mx = 100000;
    int[] tree = new int[mx + 1];
    long res = 0;

    for (int i = nums1.length - 1; i >= 0; --i) {
      int k = nums2[i] - nums1[i];
      res += query(tree, k + diff + shift);
      update(tree, k + shift, mx);
    }

    return res;
  }
}

/* Submission Link : https://leetcode.com/problems/number-of-pairs-satisfying-inequality/submissions/874810420/ */
