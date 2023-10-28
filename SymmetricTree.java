//there are two ways to resolve this

// simplest being the DFS 
// we go through each and every node and store the children in the queue
// if the elements are the same 
// the tree is symmetric else return false

//TC: O(n)
//SC: O(n)

//Implementation below

/*

class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        this.flag = true;
        dfs(root.left, root.right);
        return this.flag;
    }

    public void dfs(TreeNode left, TreeNode right)
    {
        if(left == null && right == null) return;

        if(left == null || right == null || left.val !=right.val) 
        {
            this.flag = false;
            return;
        }


        if(this.flag!=false)
        {
            dfs(left.left,right.right);
            dfs(left.right,right.left);
        }
    }
}

*/

// next being BFS

// when traversing through each level ,add the children in the queue in such a 
//way that both elements are equal else return false

//TC: O(n)
//SC: O(n)

//works on leetcode

public class SymmetricTree {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root.left);
            q.add(root.right);
            while(!q.isEmpty())
            {
                    TreeNode left = q.poll();
                    TreeNode right = q.poll();
    
                    if(left == null && right == null) continue;
    
                    if(left == null || right == null || left.val != right.val)
                    {
                        return false;
                    }
    
                    q.add(left.left);
                    q.add(right.right);
                    q.add(left.right);
                    q.add(right.left);
            }
            return true;
        }
    }
}
