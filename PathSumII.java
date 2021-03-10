// Time Complexity : O(n) we have to visit every node
// Space Complexity : O(1) auxilary space - constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach
//Recursively move from one level to another level, when you reach the leaf node should be equal to runningSum == targetSum

class PathSumII {
    private List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return list;
        recursion(root, 0, targetSum, new ArrayList<Integer>());
        return list;
    }
    
    private void recursion(TreeNode node, int runningSum, int targetSum, List<Integer> rl){
        runningSum += node.val;
        rl.add(node.val);
        
        //terminating case
        if(node.left == null && node.right == null && runningSum == targetSum){
            list.add(new ArrayList<Integer>(rl));
        }
        
        //logic
        if(node.left != null){            
            recursion(node.left, runningSum, targetSum, rl);
            rl.remove(rl.size()-1);
        }
        if(node.right != null){
            recursion(node.right, runningSum, targetSum, rl);
            rl.remove(rl.size()-1);
        }
    }
}
