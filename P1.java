/*
Depth-First Search (DFS) with Backtracking

Time Complexity (TC):
O(N) in the worst case, where 
N is the number of nodes in the tree.
Each node is visited once, and we perform 
O(1) operations per node.

Space Complexity (SC):
Recursive Stack: 
O(H), where 
H is the height of the tree. In a balanced tree, 
H=O(logN), and in a skewed tree, 
H=O(N).
Temporary List (Path Storage): At worst, each path from root to leaf is stored, leading to 
O(N).
Result List: In the worst case, all leaf paths satisfy the condition, storing 
O(N) lists, making it 
O(N).
Overall: 
O(N) in the worst case due to result storage.
Explanation of the Code in Three Sentences:
The function performs a depth-first search (DFS) traversal while maintaining a running sum and a path list. 
If a leaf node is reached and the sum matches the target, the path is added to the result list. 
Backtracking ensures that each path is explored independently by removing the last element before returning.
 */

 class Solution {

    List<List<Integer>> result;

    int target;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        result = new ArrayList<>();

        target = sum;

        if(root == null) return result;

        dfs(root, 0, new ArrayList<>());

        return result;

    }

    private void dfs(TreeNode root, int currSum, List<Integer> temp){

        // Base 

        if(root == null) return;

        currSum += root.val;

        temp.add(root.val);

        if(root.left == null && root.right == null){

            if(target == currSum){

                result.add(new ArrayList<>(temp));

            }

        }

        // logic

        dfs(root.left, currSum, temp);

        dfs(root.right, currSum, temp);

        // backtrack

        temp.remove(temp.size() - 1);

    }

    

}