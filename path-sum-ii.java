//Time Complexity : O(n), for worst case all the leaf node paths will be copied
//Sace complexity : O(h), path list will have elements equal to height of tree in worst case O(h), and recursive stack space O(h), (not considering the new list created which were created when we copied elements to add to the result list, because it is required output). hence O(h)+O(h)= O(h)
class Solution {
    //class variable, list data structure that is the output
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //base case, empty tree, return empty array list
        if (root==null)
        {
            return new ArrayList<>();
        }
        //result is the new array list
        result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }
    
    private void dfs(TreeNode root, int targetSum, List<Integer> path)
    {
        //base case
        if (root==null)
        {
            return;
        }
        //logic
        //action
        //path is a list consisting of the nodes that are visited
        path.add(root.val);
        //if the node is leaf node and diff of targetSum and value of the current node is 0,
        //add the respective path (list of the nodes) to the result list
        if (root.left == null && root.right == null)
        {
            if (targetSum -root.val==0)
            {
                result.add(new ArrayList<>(path)); //
            }
        }
        //RECURSE
        //call dfs on the left sub tree
        dfs (root.left, targetSum-root.val, path); 
        //cal dfs on right subtree
        dfs (root.right, targetSum-root.val, path);
        
        //BACKTRACK , to eliminate the need to create new list for path at every node
        //can use the path list from previous node by removing the current node
        path.remove(path.size() - 1);
      
    }
}
