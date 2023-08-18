public class Problem101{
  public boolean isSymmetric(TreeNode root) {
          Queue<TreeNode> tree=new LinkedList<>();
          tree.add(root.left);
          tree.add(root.right);
          while(!tree.isEmpty()){
              TreeNode left=tree.poll();
              TreeNode right= tree.poll();
              if(left==null && right==null)
                  continue;
              if(left==null || right==null || left.val!=right.val)
                  return false;
              tree.add(left.left);
              tree.add(right.right);
              tree.add(left.right);
              tree.add(right.left);
          }
          return true;
      }
  public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
    }
}
