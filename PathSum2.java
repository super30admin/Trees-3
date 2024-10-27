class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result=new ArrayList<>();
        helper(root,targetSum,new ArrayList<>(),0);
        return result;
    }
    
    private void helper(TreeNode root,int targetSum,List<Integer> path,int currSum){
        //base case
        if(root==null) return;
        
        currSum+=root.val;
        path.add(root.val);
        
        
        if(root.left==null && root.right==null){
            if(currSum==targetSum){
                result.add(path);
            }
        }
        helper(root.left,targetSum,new ArrayList<>(path),currSum);
        helper(root.right,targetSum,new ArrayList<>(path),currSum);
    }
}