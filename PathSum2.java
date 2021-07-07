/*
Author: Akhilesh Borgaonkar
Problem: LC 113. Path Sum II (Trees-3)
Approach: Using recursive approach here. Checking the base conditions to find a path summing to input sum. If the sum is found then add the path
	to resultant list else backtrack to parent node and recursively do dfs on other nodes to check the sum of paths. 
Time Complexity: O(n) where n is number of total nodes in the Binary Tree.
Space complexity: O(n) where n is number of total nodes in the Binary Tree.
LC verified.
*/


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        
        dfs(root, currList, result, sum);
        return result;
    }
    
    private void dfs(TreeNode root, List<Integer> currList, List<List<Integer>> result, int sum){
        //base case 1
        if(root == null)
            return;
        //if root is not null and valid then add it to current list
        currList.add(root.val);
        //base case 2
        if(root.left == null && root.right == null){    //means we are at leaf node
            if(sum == root.val){    //check if we have got the required sum
                result.add(new ArrayList<>(currList));  //if required sum acquired then add the current list to resultant list
                return;
            }
        }
        
        //base case 3
        if(root.left != null){
            //if the left node is present then call dfs on left node
            dfs(root.left, currList, result, sum-root.val);
            //backtrack to parent node by removing the recent node value from current list as the node doesn't get me required sum
            currList.remove(currList.size()-1);
        }
        
        //base case 4
        if(root.right != null){
            //if right node is not null then call dfs on right node
            dfs(root.right, currList, result, sum-root.val);
            //backtrack to parent node by removing curent node value from current list
            currList.remove(currList.size()-1);
        }
    }
}


