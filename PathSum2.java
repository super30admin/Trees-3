import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class PathSum2 {

      public class TreeNode {
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


        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

            if(root == null){
                return result;
            }
            int rsum =0;
            List<Integer> elem = new ArrayList<>();
            calcSum( elem, root, rsum, targetSum);
            return result;
        }

        public void calcSum( List<Integer> elem, TreeNode root, int rsum, int targetSum){
            if(root == null){
                return;
            }

            rsum += root.val;
            elem.add(root.val);
            if(root.left == null && root.right == null){
                if( rsum == targetSum){
                    result.add(new ArrayList<>(elem));
                }
            }

            calcSum(elem, root.left,rsum, targetSum );
            calcSum(elem, root.right,rsum, targetSum);

            elem.remove(elem.size()-1);
            rsum -= root.val;

        }

}
