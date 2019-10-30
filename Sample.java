// Time Complexity :O(N)
// Space Complexity :O(N^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Nope. 


// Your code here along with comments explaining your approach
class Solution {
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