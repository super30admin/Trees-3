// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//we are maintiaing a list to track the path but the datastructure under a datastructure is a reference.
//when ever we are updating the list we are not only updating at our current position it updates at every position we used till now as all of them had same refernce
// we can avoid this by taking a new list at evry root but is cost's more memory
//instead of taking new list at every root we are using backtracking(just removing the root once the left and right calls that root is finidhed)
//in backtracking irrespective of our condition it removes all the nodes as we don't have control on it.
//to get our results based on our condition when ever we hot our condyion we will create a new list and will copy the result into the list
//so that we can have our results copied into new lists and we can return them.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>>  result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        target = targetSum;
        helper(root,0,new ArrayList<>());
        return result;
        
    }
    private void helper(TreeNode root,int currsum,List<Integer> path){
        //base
        if(root == null) {
            return;
        }
      
        path.add(root.val);
        currsum = currsum + root.val;
        //we need ti check we  are at leaf node or not, if we are at leaf node need to check whether the sum is equal to target or not
        if(root.left == null && root.right == null && currsum == target){
            
           result.add(new ArrayList<>(path));
            
        }
        
        helper(root.left,currsum,path);
        
        //st.pop()
         
        helper(root.right,currsum,path);
        //st.pop();
        path.remove(path.size()-1);
       
        
    }
}
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer> map ;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       map = new HashMap<>();
    if(preorder == null || preorder.length == 0) return null;
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
            }
        return helper(preorder,inorder,0,inorder.length-1);
             //return helper;   
        }
    private TreeNode helper(int[] preorder, int[] inorder,int start,int end){
        if(start > end) return null;
        int rootval = preorder[index];//in java by int gives 0 by default
        index++;
        int iidx = map.get(rootval);//getting the index from inordrer list
        TreeNode root = new TreeNode(rootval);
       root.left = helper(preorder,inorder,start,iidx-1);
       root.right = helper(preorder,inorder,iidx+1,end);
        return root;
    }
}
