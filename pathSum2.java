//Time Complexity:O(N)
//Space Complexity:O(N)
//In this problem, I'll be creating 2 lists, 1 to hold my final resultant list and the other to hold the element in my current path. I'll be running a separate recursive function, which will do the actual operation. If my root is null, I won't be doing anything. I'll be adding the root value to my cur list each time the recursive function is called. If the left is null and the right is null and if the sum is equal to my root value, i'll simply append my cur list to my result list. If left is not null I'll traverse through the left path and check the same and if my right is not null, I'll repeat the same process. Each time when I move up from my leftmost path to its root or right most path to my root, I'll remove those elements from my cur list.
//This code was executed successfully and got accepted in leetcode.


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        dfs(root,sum,res,cur);
        return res;
    }
    private void dfs(TreeNode root,int sum, List<List<Integer>> res,List<Integer> cur){
        if(root==null){
            return;
        }
        cur.add(root.val);
        if(root.left==null&&root.right==null&&sum==root.val){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(root.left!=null){
            dfs(root.left,sum-root.val,res,cur);
            cur.remove(cur.size()-1);
        }
        if(root.right!=null){
            dfs(root.right,sum-root.val,res,cur);
            cur.remove(cur.size()-1);
        }
    }
}