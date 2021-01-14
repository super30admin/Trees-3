// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
// iterate though tree  add node to temp array if sum at leaf node equal target, add it to result.
// when we come out of recursion call remove last element from temp.

public List<List<Integer>> pathSum(TreeNode root, int sum) {
    return helper(root, sum, new ArrayList<List<Integer>>(), new ArrayList<Integer>(), 0);
}

public static List<List<Integer>> helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> temp, int currSum){
    if(root == null) return result;
    currSum+=root.val;
    temp.add(root.val);
    if(root.left == null && root.right == null){
        if(currSum == sum){
            result.add(new ArrayList<Integer>(temp));
        }
        temp.remove(temp.size()-1);
        return result;
    }
    if(root.left != null)
        result= helper(root.left,sum,result,temp,currSum);
    if(root.right != null)
        result = helper(root.right,sum,result,temp,currSum);
    temp.remove(temp.size()-1);
    return result;
}


