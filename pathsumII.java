class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result=new ArrayList();
        target=sum;
        helper(root,0,new ArrayList());
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> temp){
        if(root==null){
            return;
        }
        sum=sum+root.val;
        temp.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==target){
                result.add(new ArrayList(temp));
            }
        }
        helper(root.left,sum,temp);
        helper(root.right,sum,temp);
        temp.remove(temp.size()-1);
    }
}