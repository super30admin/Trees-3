class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        res = new ArrayList<>();
        if(root==null) return res;
        helper(root,targetSum,0, new ArrayList<>());
        return res;
    }
    private void helper(TreeNode root, int target, int sum, List<Integer> path){
        sum = sum +root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==target){
                res.add(new ArrayList(path));
            }

        }
        if(root.left!=null)
        helper(root.left,target,sum,path);
        if(root.right!=null)
        helper(root.right,target,sum,path);
        
        path.remove(path.size()-1);
    }
}
