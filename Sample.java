//****PATH SUM-2****

// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :

class Solution {
    List<List<Integer>> finallist=new ArrayList();
    
    ArrayList<Integer> path=new ArrayList();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        
    mypath(root,targetSum,0, path);
        
        return finallist;
        
        
    }
private void mypath(TreeNode root, int targetsum, int currentsum, ArrayList<Integer> path)
{
    //Base case:
    if(root==null)
    {
        return;
    }
    
    //ACTION
    //Logic:
    currentsum=root.val+currentsum;
    path.add(root.val);
    
    //RECURSE
    //Traversing
    mypath(root.left, targetsum ,currentsum, path);
    //st.pop();
    if(root.left==null && root.right==null)
    {
        if(currentsum==targetsum)
        {
            
            finallist.add(new ArrayList(path));
        }
    }
    mypath(root.right, targetsum,currentsum, path);
    
    //Backtrack
    path.remove(path.size()-1);
        
        
    
    }
}

// Your code here along with comments explaining your approach
