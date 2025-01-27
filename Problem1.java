// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YEs
// Any problem you faced while coding this :No
public class Problem1 {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        target = targetSum;
        //have a variable current sum and an list which contains the node at each call
        dfs(root,0,new ArrayList<>());
        return result;

    }

    private void dfs(TreeNode root, int currSum, List<Integer> list){
        if(root == null){
            return;
        }
        //curr sum will be increasing with value of the node at each call
        currSum = currSum + root.val;
        //we'll be adding the root in the path as well
        list.add(root.val);
        if(root.left == null && root.right == null){
            //if we've reached the root node check if the target is equal to currSum add the list into the new Arrays list and add to the result.
            if(currSum ==  target){
                result.add(new ArrayList<>(list));
            }
        }
        //now go to root's left
        dfs(root.left,currSum,list);
        //now go to root's right
        dfs(root.right,currSum,list);
        //and we reach the leaf or end of the search for left and right node we just remove the last element from the list.
        list.remove(list.size()-1);
    }
}
