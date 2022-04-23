// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//recursion way with backtracking
List<IList<int>> result = new List<IList<int>>();
 public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        
    if(root == null)
        return result;
    
    helper(root, 0, targetSum, new List<int>());
    return result;
 }

 private void helper(TreeNode root, int curSum, int targetSum, List<int>() path)
 {

    //base condition
    //this is not leaf node, it means we are at null node
     if(root == null)
        return;
    
    currSum += root.val;
    path.Add(root.val);

    if(root.left == null && root.right == null && targetSum == currSum)
    {
        //we create new list when adding to result
        //because when we do backtracking, we make the path empty 
        //and add reference will effect the result
        result.Add(new List<int>(path));
    }

    //logic
    //traverse the left tree
    helper(root.left, currSum, targetSum, path);
    //traverse the right tree
    helper(root.right, currSum, targetSum, path);

    //backtrack
    //so what we can do is go back 1 step instead of creating new list everytime
    path.RemoveAt(path.Count - 1);
 }



//recursion way
// 1) Recursion, do DFS
// 2) When reached to leaf, we will add it to list
//     a. If target sum equals to curr sum
// 3) O(n), O(n)
// 4) Disadvantage
//     a. Copy over the elements every time because we need to create new list everytime
//     b. How to do better space

 List<IList<int>> result = new List<IList<int>>();
 public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        
    if(root == null)
        return result;
    
    helper(root, 0, targetSum, new List<int>());
    return result;
 }

 private void helper(TreeNode root, int curSum, int targetSum, List<int>() path)
 {

    //base condition
    //this is not leaf node, it means we are at null node
     if(root == null)
        return;
    
    currSum += root.val;
    path.Add(root.val);

    if(root.left == null && root.right == null && targetSum == currSum)
    {
        result.Add(path);
    }

    //logic
    //Copy over the elements every time because we need to create new list everytime
    //traverse the left tree
    helper(root.left, currSum, targetSum, new List<int>(path));
    //traverse the right tree
    helper(root.right, currSum, targetSum, new List<int>(path));

 }