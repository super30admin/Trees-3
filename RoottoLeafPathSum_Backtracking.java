import java.util.List;
import java.util.ArrayList;

public class RoottoLeafPathSum_Backtracking {

    //BACKTRACKING

        List<List<Integer>> result;

        List<Integer> path;

        int target;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

            this.result = new ArrayList<>();

            this.path = new ArrayList<>();

            target = targetSum;

            helperDFS(root, 0);

            return result;
        }

        private void helperDFS(TreeNode root, int currSum) {

            //base

            if(root == null) return;

            //logic

            currSum = currSum + root.val;

            // NOT PRESENT IN BACKTRACK APPROACH
            // List<Integer> pathNow = new ArrayList<>(path); // O(n^2) = O(nH)

            //action

            path.add(root.val); // O(H) space i.e.,
            //no more number of elements in the list (recursive stack space)than the height of the tree
            // O(H) = O(n) in the worst case

            if(root.left == null && root.right == null) {

                if(currSum == target) { // such instances < number of leaf nodes i.e., < n/2

                    //System.out.println(path);
                    result.add(new ArrayList<>(path));
                }
            }

            //recurse

            // O(n) time traversing over all nodes
            helperDFS(root.left, currSum);
            //st.pop()

            helperDFS(root.right, currSum);
            //st.pop()

            //BACKTRACK

            path.remove(path.size() - 1);
        }


/*

Time Complexity = O(n)

Space Complexity = O(n)

/*
List<Integer> path can be global as the same reference remains even if path is a local parameter
*/

/* currSum goes in as a primitive local variable/ parameter
whereas, a list is going inside as a reference(pointer) so the backtracking is essential
*/


}
