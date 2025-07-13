// RecursiveTime Complexity :O(n)

// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root==null){
            return new ArrayList<>();
        }
        result = new  ArrayList<>();
        dfs(root,0,targetSum,new  ArrayList<>());
        return result;
        
    }
   private void dfs(TreeNode root,int currentSum,int targetSum,List<Integer>path){
     if (root==null){
        return;
        }
        currentSum=currentSum+root.val;
        path.add(root.val);
     if(root.left==null&&root.right==null){
        if(currentSum==targetSum){
        result.add(new ArrayList<>(path));
        }
     }

     dfs(root.left,currentSum,targetSum,path);   
     dfs(root.right,currentSum,targetSum,path);
        
        path.remove(path.size() - 1);
    }
}

