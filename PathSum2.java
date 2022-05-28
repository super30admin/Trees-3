// Time Complexity : O(N) where N is the number of nodes
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Use recursion and backtracking, keep track of sum, when leaf node is hit and sum== target then add the list of path
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> result= new ArrayList<>();

        helper(root,targetSum,new ArrayList<>(),result,0);
        return result;
    }

    private void helper(TreeNode root, int ts, ArrayList<Integer> tempList,
                        List<List<Integer>> result,int sum){

        //Base case
        if(root==null) return;

        //Action
        sum+=root.val;
        tempList.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==ts){
                result.add(new ArrayList(tempList));
            }
        }

        //Recurse
        helper(root.left, ts, tempList,result,sum);
        helper(root.right, ts, tempList,result,sum);

        //BackTrack
        tempList.remove(tempList.size()-1);
    }
}
//https://www.youtube.com/watch?v=yLwh3t0RHmk