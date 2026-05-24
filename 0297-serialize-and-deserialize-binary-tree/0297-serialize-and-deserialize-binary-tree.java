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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "null";
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append("null").append(",");
            }else{
                sb.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null"))return null;
        String[] nodes=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int i=1;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(!nodes[i].equals("null")){
                curr.left=new TreeNode(Integer.parseInt(nodes[i]));
                q.add(curr.left);
            }
            i++;
            if(!nodes[i].equals("null")){
                curr.right=new TreeNode(Integer.parseInt(nodes[i]));
                q.add(curr.right);
            }
            i++;

        }
        return root;

        
    }
}
