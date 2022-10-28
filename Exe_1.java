class Solution {
    List<List<Integer>> a;
    List<Integer> p;
    int ps;
    int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        this.a = new ArrayList<>();
        this.p = new ArrayList<>();
        this.ps=0;
        pathSum(root);
        return a;
        
    }
    public void pathSum(TreeNode n){
        if(n == null){
            return;
        }
        p.add(n.val);
        ps += n.val;
        if(n.left == null && n.right == null){
            if(ps == targetSum){
                a.add(new ArrayList<Integer>(p));
            }
        }
        pathSum(n.left);
        pathSum(n.right);
        ps -= n.val;
        p.remove(p.size()-1);
    }
}
//tc = O(n)
//sc = O(n)
