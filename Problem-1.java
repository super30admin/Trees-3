class Solution {
    //Time Complexity :- O(n)
    //Space Complexity :- O(1)
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetsum) {
        this.result = new ArrayList<>();
        sumofthepath(root,targetsum,new ArrayList<>(),0);
        return result;
    }
    private void sumofthepath(TreeNode root,int targetsum,List<Integer>path,int sum){
        //base condition
        if(root == null) return;
        //Logic
        path.add(root.val);
        sum+=root.val;
        sumofthepath(root.left,targetsum,path,sum);
        if(root.left == null && root.right == null && sum==targetsum){
            result.add(new ArrayList<>(path));
        }
        sumofthepath(root.right,targetsum,path,sum);
        path.remove(path.size() - 1);
    }
}