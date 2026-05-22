class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int preindex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Fill map (inorder value → index)
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int instart, int inend) {
        if (instart > inend) return null;

        int rootval = preorder[preindex++];
        TreeNode root = new TreeNode(rootval);

        int inindex = map.get(rootval);

        root.left = build(preorder, instart, inindex - 1);
        root.right = build(preorder, inindex + 1, inend);

        return root;
    }
}