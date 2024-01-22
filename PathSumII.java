// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: DFS(recursion)
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result= new ArrayList<>();
        if(root==null) return result;
        
        List<Integer> list= new ArrayList<>();
        findPath(root, targetSum, list, result);
        return result;
    }
    public void findPath(TreeNode root, int targetSum,List<Integer> list,List<List<Integer>> result){
        if(root==null) return;
        list.add(root.val);

        if(root.left==null && root.right==null && targetSum-root.val==0){
            result.add(new ArrayList<>(list));
        }
        findPath(root.left, targetSum-root.val, list, result);
        findPath(root.right, targetSum-root.val, list, result);

        list.remove(list.size()-1);
    }
}