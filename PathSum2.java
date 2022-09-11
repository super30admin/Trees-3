import java.util.ArrayList;
import java.util.List;

//Time:for n nodes there would be n/2 leafs, worst case if we create deep copies at all leafs then O(n^2)
//Space: O(h) then in worst case would be O(n)
class PathSum2 {
    List<List<Integer>> results;
    List<Integer> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        results = new ArrayList<>();
        result = new ArrayList<>();
        //dfs(root,targetSum,new ArrayList<>());
        helper(root,targetSum);
        return results;
    }
    //create new List at each call
    /*public void dfs(TreeNode root, int remainder, List<Integer> path)
    {
        if(root == null)
            return;
        
      
        path.add(root.val);
        dfs(root.left, remainder - root.val,new ArrayList<>(path));
         if(remainder == root.val && root.left == null && root.right == null)
        {
             //path.add(root.val);
            results.add(path);
            return;
        }
        dfs(root.right, remainder - root.val,new ArrayList<>(path));
        
    }*/
    
   
    /*public void dfs(TreeNode root, int remainder, List<Integer> path)
    {
        if(root == null)
            return;
      
        if(remainder == root.val && root.left == null && root.right == null)
        {
            path.add(root.val);
            results.add(path);
            return;
        }
        if(root.left == null && root.right == null)
            return;
        //why this doesn't work: 4 was added to the reference passed by 5 to 4, that same reference was passed to right recursion
        //path.add(root.val);
        
        List<Integer> list = new ArrayList<>(path);
        list.add(root.val);
        ////why this doesn't work: 4 was added to the reference passed by 5 to 4, that same reference was passed to right recursion, 4 is always passed to the right recursion
        //path.add(root.val);
        dfs(root.left, remainder - root.val,list);
         //stack.pop()
       
        dfs(root.right, remainder - root.val,list);
        
    }*/
    public void helper(TreeNode root, int remaining)
    {
        //at every node 
        //action would be adding the element to the list
        
        //backtracking would be nullifying the action: i.e. that action is backtracked
        if(root == null)
            return;
        
        remaining -= root.val;
        
        //action
        result.add(root.val);
        if(remaining ==0 && root.left == null && root.right == null)
        {
            results.add(new ArrayList<>(result));
            
        }
        //recurse
        helper(root.left,remaining);
        helper(root.right,remaining);
        //backtrack
        result.remove(result.size()-1);
        
    }
}