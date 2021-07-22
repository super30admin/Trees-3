import java.util.*;
public class SymmetricTree {
        public boolean isSymmetric(TreeNode root) {

            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();

            preOrder(root.left, left);
            postOrder(root.right, right);

            if(left.size() != right.size() ) return false;

            int leftIndex = 0;
            int rightIndex = right.size()-1;

            while(rightIndex >= 0) {
                if(left.get(leftIndex) != right.get(rightIndex)) return false;
                leftIndex++; rightIndex--;
            }
            return true;
        }

        public void preOrder(TreeNode root, List<Integer> curr) {

            if(root == null ) {
                curr.add(-111); // some number out of constrain to track null nodes
                return;
            }
            curr.add(root.val);
            preOrder(root.left, curr);
            preOrder(root.right, curr);

        }

        public void postOrder(TreeNode root, List<Integer> curr) {
            if(root == null ) {
                curr.add(-111); // some number out of constrain to track null nodes
                return;
            }

            postOrder(root.left, curr);
            postOrder(root.right, curr);
            curr.add(root.val);
        }
       public static void main(String[] args){
            SymmetricTree st = new SymmetricTree();
            TreeNode root;
           root = new TreeNode(1);
           root.left = new TreeNode(2);
           root.right = new TreeNode(2);
           root.left.left = new TreeNode(3);
           root.right.left = new TreeNode(4);
           root.left.right = new TreeNode(4);
           root.right.right = new TreeNode(3);
            System.out.print(st.isSymmetric(root));
       }
}
