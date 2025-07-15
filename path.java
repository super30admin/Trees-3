class Solution {
    List<List<Integer>>res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       this.res=new ArrayList<>();
       helper(root,targetSum,0,new ArrayList<>());
       return res;
          }
          private void helper(TreeNode root,int target,int currsum,List<Integer>path){
            if(root==null)return;
            path.add(root.val);
            currsum+=root.val;
            if(root.left==null &&root.right==null&&target==currsum)res.add(new ArrayList<>(path));
            helper(root.left,target,currsum,path);
            helper(root.right,target,currsum,path);
            path.remove(path.size()-1);
          }
}