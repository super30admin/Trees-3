class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root)
    {
        if(root== null)
        {
            return true;
        }

        return (isSymmetricutil(root.left, root.right));
    }
    public boolean isSymmetricutil(TreeNode root1, TreeNode root2)
    {   if(root1== null || root2==null)
        return root1== root2;

        return (root1.val== root2.val)&& isSymmetricutil(root1.left, root2.right)
                && isSymmetricutil(root1.right, root2.left);
    }
    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(tree.isSymmetric(root));
    }

}
