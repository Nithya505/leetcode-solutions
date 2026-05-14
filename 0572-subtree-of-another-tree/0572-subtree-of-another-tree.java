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

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)return false;
        if(issametree(root,subRoot))return true;
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    private boolean issametree(TreeNode s,TreeNode t){
        if(s==null&&t==null)return true;
        if(s==null||t==null)return false;
        if(s.val!=t.val)return false;
        return issametree(s.left,t.left)&&issametree(s.right,t.right);
    }
}
