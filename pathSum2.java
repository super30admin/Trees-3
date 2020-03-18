/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> result ;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result= new ArrayList<>();
        if(root == null)
            return result;
        pathSumUtil(root, sum, new ArrayList<>());
        return result;
    }
    private void pathSumUtil(TreeNode root, int sum, List<Integer> list ){
        //base case
        if(root == null)
            return;
        //add cur elements to list
        list.add(root.val);
        sum -= root.val;
        //if its a leaf node and 
        if(isLeaf(root) && sum ==0)
            result.add(new ArrayList<>(list));
        else{
            //parent will substract its value from the sum and ask its childrent if they can make the remaining sum.
            pathSumUtil(root.left, sum, list);
            pathSumUtil(root.right, sum, list) ; 
        }    
        //while backtracking to parent node, child will remove itself from the list, before exploring different options;
        list.remove(list.size()-1);
    }
    //funtion to check if current node is leaf node
    private boolean isLeaf(TreeNode root){
        return root.left ==null && root.right == null;
    }
}

