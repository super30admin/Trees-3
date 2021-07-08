// Time Complexity :O(N)
// Space Complexity :O(N^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Nope. 


// Your code here along with comments explaining your approach
class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumHelper(root,new ArrayList<>(),result,sum);
        return result;
    }
    public void pathSumHelper(TreeNode root,List<Integer> list, List<List<Integer>> result, int sum){
    	//Base Case
        if(null == root){return;}
        if(null == root.left && null == root.right){
            if(sum == root.val){
                List<Integer> newList = new ArrayList<>(list);
                newList.add(root.val);
                result.add(newList);
            }
            return;
        }
        List<Integer> leftList = new ArrayList<>(list);
        leftList.add(root.val);
        pathSumHelper(root.left,leftList,result,sum-root.val);
        List<Integer> rightList = new ArrayList<>(leftList);
        pathSumHelper(root.right,rightList,result,sum-root.val);
    }
}

//Time Complexity :O(N)
//Space Complexity :O(1)+ recursion stack
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :Nope. 


//Your code here along with comments explaining your approach
class Solution2 {
    public boolean isSymmetric(TreeNode root) {
     if(null == root){return true;}
    return isSymmetricTree(root.left,root.right);
    }
    public boolean isSymmetricTree(TreeNode root1, TreeNode root2){
        if(((null == root1) && (null == root2))){return true;}
        if(((null == root1) && (null != root2)) || ((null == root2) && (null != root1))){return false;}
        return root1.val == root2.val && isSymmetricTree(root1.left,root2.right)&&isSymmetricTree(root1.right,root2.left);  
    }
}