// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Recursive approach where each root value is being added to a temp list and temp sum and checked if we reached the leaf and the temp sum is equal to the target.
 * The list is added to the resultant list and the last element in the temp list is removed.
 * Left and right subtrees are recursively traversed. 
 */

    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        result = new ArrayList<>();
        
        List<Integer> currentList = new ArrayList<>();
        
        pathSumHelper(root,sum,currentList,0);
        
        return result;
    }
    
    
    public void pathSumHelper(TreeNode root,int sum,List<Integer> currentList,int currentSum){
        if(root == null)
            return;
        
        
        currentList.add(root.val);
        
        currentSum += root.val;
        
        if(root.left == null && root.right == null && sum==currentSum){
            result.add(new ArrayList<>(currentList));
            currentList.remove(currentList.size()-1);
            return;
        }
        
        pathSumHelper(root.left,sum,currentList,currentSum);
        pathSumHelper(root.right,sum,currentList,currentSum);
        
        
        currentList.remove(currentList.size()-1);
        
    }

    
    
 // Time Complexity : O(n)
 // Space Complexity : O(1)
 // Did this code successfully run on Leetcode : yes
 // Any problem you faced while coding this : no


 // Your code here along with comments explaining your approach
 /*
  * A symmetric tree is nothing but checking if the left of node and right of node values are equal and a mirror image is followed at every level.
  * A recursive approach to check the conditions and return false if the values mismatch, at the same time return true when we hit a null with all values being equal will make it a symmetric tree.
  * 
  */
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        return isSymmetricHelper(root.left,root.right);
        
    }
    
    private boolean isSymmetricHelper(TreeNode n1,TreeNode n2){
        if(n1==null && n2 == null)
            return true;
        
        if( (n1 == null && n2!=null) || (n1 != null && n2 == null))
            return false;
        
        if(n1.val != n2.val)
            return false;
        
        return isSymmetricHelper(n1.left,n2.right) && isSymmetricHelper(n1.right,n2.left);
    }
 
    
    