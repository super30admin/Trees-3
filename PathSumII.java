
// Time Complexity : O(n^2)
//Space Complexity : O(n^2) as we are recursivly using auxilary space at every point  
//Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target = sum;
        result = new ArrayList<>();
        if(root == null) return result;
         helper(root, 0, new ArrayList<>());
        return result;
    }
    
    public void helper(TreeNode root, int currSum, List<Integer> temp){
        
        //base
        if (root == null) return;
        //logic 
        currSum += root.val;
         temp.add(root.val);
        if(root.left == null && root.right==null){
            if(currSum == target){
                result.add(temp);
            }
           
        }
        
        helper(root.left, currSum, new ArrayList<>(temp));
        helper(root.right, currSum, new ArrayList<>(temp));
        
        
    }
}

//----------------Back Tracking Solution----------------
// Time Complexity : O(n)
//Space Complexity : O(n) as we are recursivly using auxilary space at every point  
//Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target = sum;
        result = new ArrayList<>();
        if(root == null) return result;
         helper(root, 0, new ArrayList<>());
        return result;
    }
    
    public void helper(TreeNode root, int currSum, List<Integer> temp){
        
        //base
        if (root == null) return;
        //logic 
        currSum += root.val;
         temp.add(root.val);
        if(root.left == null && root.right==null){
            if(currSum == target){
                result.add(new ArrayList(temp));
            }
           
        }
        
        helper(root.left, currSum, temp);
        helper(root.right, currSum, temp);
        
        temp.remove(temp.size() -1);
        
    }
}