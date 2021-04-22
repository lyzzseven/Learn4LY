package LeeCode;

import com.fasterxml.jackson.core.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 深度优先遍历
 */
public class Solution {
        int ans;
        Map<Integer, Integer> left;
        public int widthOfBinaryTree(TreeNode root) {
            ans = 0;
            left = new HashMap();
            dfs(root, 0, 0);
            return ans;
        }
        public void dfs(TreeNode root, int depth, int pos) {
            if (root == null) return;
            left.computeIfAbsent(depth, x-> pos);
            ans = Math.max(ans, pos - left.get(depth) + 1);
//            dfs(root.left, depth + 1, 2 * pos);
//            dfs(root.right, depth + 1, 2 * pos + 1);
        }
}
