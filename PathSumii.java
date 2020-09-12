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
//Time Complexity-O(n)
//Space Complexity=O(n)
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer>curPath=new ArrayList();
        List<List<Integer>>output=new ArrayList();
        calculatePathSum(root,sum,0,curPath,output);
        return output;
    }
    public void calculatePathSum(TreeNode root,int sum,int currentSum,List<Integer>curPath,List<List<Integer>>output)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {      
            currentSum+=root.val;
            if(sum==currentSum)
            {
                List<Integer>temp=new ArrayList(curPath);
                temp.add(root.val);
                output.add(temp);
            }
            return;            
        }
        curPath.add(root.val);
        currentSum+=root.val;
        calculatePathSum(root.left,sum,currentSum,curPath,output);
        calculatePathSum(root.right,sum,currentSum,curPath,output);
        curPath.remove(curPath.size()-1);
    }

}