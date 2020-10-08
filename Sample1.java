// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


Q1)
//Not sure of time complexity O(N) but traversing multiple paths,O(N)
//traverse from root to leaf untill the sum is 0 and save all branches
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList();
        findPath(root,sum,new ArrayList<Integer>(),result);
        return result;   
    }
    
    private void findPath(TreeNode root,int sum,List<Integer> current,List<List<Integer>>result){
        if(root==null) return ;
        current.add(root.val);
        if(root.val==sum && root.left==null && root.right==null){
            result.add(current);
            return;
        }
        findPath(root.left,sum-root.val,new ArrayList<Integer>(current) ,result);
        findPath(root.right,sum-root.val,new ArrayList<Integer>(current),result);
    }
        
}


Q2)//O(N) , O(N)
//if any one tree is missing tthen false or value is not same
//root.left will become root.right and vice versa
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
}

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if(t1==null || t2==null) return false;
        return (t1.val==t2.val) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
        
    }
}