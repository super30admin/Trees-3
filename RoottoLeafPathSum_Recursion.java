import java.util.List;
import java.util.ArrayList;

public class RoottoLeafPathSum_Recursion {

    //RECURSION

        List<List<Integer>> result;

        int target;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

            this.result = new ArrayList<>();

            target = targetSum;

            helperDFS(root, 0, new ArrayList<>());

            return result;
        }
        private void helperDFS(TreeNode root, int currSum, List<Integer> path) {

            //base

            if(root == null) return;

            //logic

            currSum = currSum + root.val;

            List<Integer> pathNow = new ArrayList<>(path); // O(n^2) = O(nH)

            //action

            pathNow.add(root.val);

            if(root.left == null && root.right == null) {

                if(currSum == target) {

                    result.add(pathNow);
                }
            }

            //recurse

            helperDFS(root.left, currSum, pathNow);
            //st.pop()

            helperDFS(root.right, currSum, pathNow);
            //st.pop()
        }


/*

Time Complexity = O(n^2)

We are  traversing over n nodes in a tree,

in the worst case H (precisely, H-1) nodes can go inside the deep copy of list of integers,

if the tree is skewed, H can be n.

So, worst case Time Complexity = O(n^2)

Space Complexity = O(n^2) = O(nH)

*/
}
