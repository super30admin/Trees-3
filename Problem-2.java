// Time Complexity : O(n)
// Space Complexity : O(h) using dfs and O(n/2) using BFS
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Solution 1: using BFS
// Time: O(n) , Space: O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        //Time: O(n) , Space: O(n) for queue in worst case + O(max nodes of leaf O(h)) = O(n)
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> li = new ArrayList<>();
            for(int i =0; i<size; i++){
                TreeNode curr = q.poll();
                li.add(curr);
                if(curr!=null){
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }

            int l = 0, r = li.size()-1;
            while(l < r){
                if(li.get(l) == null && li.get(r)==null){
                    l++;r--;
                }else if(li.get(l) == null || li.get(r)==null){
                    return false;
                }else{
                    if (li.get(l).val!=li.get(r).val){
                        return false;
                    }
                    else{
                    l++;r--;
                    }
                }
            }
        }

        return true;
        
    }
}

//Solution 2: for Symmetric tree using DFS: optimal approach
//Time: O(n) , Space: O(h)
class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        this.flag = true;
        dfs(root.left, root.right);
        return flag;
    }

    private void dfs(TreeNode left, TreeNode right){

        //base
        if(left == null && right == null) return;
        if(left == null || right == null || left.val!=right.val){
            flag = false;
            return;
        }

        //logic
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}