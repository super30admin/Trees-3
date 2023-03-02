//Rutuja Mandlik NUID- 002191355
//DFS- Backtracking Solution
//Time Complexity: O(N) N: Traversing the tree. Each and every node just one path we are maintaining instead of copying
//Space Complexity: O(N) where N: . We are making copy of curr path and adding/ removing nodes in same list. No need to create new list everytime, instead copy of the list to store it in result and then edit the curr list
//TC: O(n)
//SC: O(n) -->Height
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, new ArrayList<>(),0, targetSum);
        return result;
    }
    
    private void helper(TreeNode root,List<Integer> path ,int currSum, int target){
        //base
        if(root == null) return;
        
        //logic
        //action
        currSum +=  root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }
        
        //recurse
        helper(root.left, path, currSum, target);
        helper(root.right, path, currSum, target);
        
        //backtrack
        path.remove(path.size()-1);
    }
}
        currPath.remove(currPath.size() - 1);
    
    }
    }
