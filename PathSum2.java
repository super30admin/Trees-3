// ############# APPROACH 1: BRUTE FORCE ##############################

// Time Complexity: O(n^2)
// Space complexity: O(n^2)

// Approach: In this approach, we need to traverse all the root to leaf paths.
// We define a global arraylist result which will contain paths equal to target sum
// We will keep a local variable currSum to keep the running sum of the branch that we are traversing.
// We need not keep in in global because we need to ovwrite with each traversal and it might be different for different branches.
// We add the root value to the currSum
// At every recursion we create a new arrayList and copy from the path from the previous recursion and then add the current root value
// We check if the root.left and root.right are the leaves, if so, then check if the currSum == target
// If the above condition is satisfied, we add this arrayList of the current recurse into the global result
// We call the recursion for root.left and root.right in PREORDER fashion

class Solution {
    List<List<Integer>>result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new ArrayList<>();
        helper(root,0,new ArrayList<>(),targetSum);
        return result;
        
        
    }
    
    private void helper(TreeNode root, int currSum,List<Integer> path, int targetSum){
        
        //base
        if(root == null) return;
        
        //logic
        
        currSum+=root.val; //Add current root value to currSum
        List<Integer> li=new ArrayList<>(path); //Create copy of arraylist with old path
        li.add(root.val); //add current element to new arraylist
        
        //preorder
        // if you hit the leaf and currSum == target
        if(root.left==null && root.right==null){
            if(currSum==targetSum){
                result.add(li); //add the final arraylist with the path to the result array
            }
        }
        
        helper(root.left,currSum,li,targetSum);
        
        helper(root.right,currSum,li,targetSum);
        
        
        
    }
}


// ############ APPROACH 2: USING BACKTRACKING #####################//

// Time Complexity: O(n)
// Space complexity: O(n)

// Approach:

class Solution {
    List<List<Integer>>result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new ArrayList<>();
        helper(root,0,new ArrayList<>(),targetSum);
        return result;
        
        
    }
    
    private void helper(TreeNode root, int currSum,List<Integer> path, int targetSum){
        
        //base
        if(root == null) return;
        
        //logic
        
        currSum+=root.val; //Add current root value to currSum
    
        //actions
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum==targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        
        helper(root.left,currSum,path,targetSum);
        
        helper(root.right,currSum,path,targetSum);
        
        //backtrack
        path.remove(path.size()-1);
        
    }
}

