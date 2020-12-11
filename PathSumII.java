//Time COmplexity - O(N)
// Space Complexity - O(N^2)
// Idea of solution backtrack.
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        helper(root,ans,new ArrayList<Integer>(),sum);
        return ans;
    }
    
    public void helper(TreeNode root,List<List<Integer>> ans,List<Integer> path,int target){
        if(root == null){
            return;
        }
        if(target == root.val && root.left == null && root.right==null){
            path.add(root.val);
            ans.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(root.val);
        helper(root.left,ans,path,target-root.val);
        helper(root.right,ans,path,target-root.val);
        path.remove(path.size()-1);
    }
}