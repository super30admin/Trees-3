//Approach -1 - BF - DFS - check left's left == right's right && left's right = right's left!
//TC- O(n) - ll nodes processed
//sc- O(h) - recursive stack of tree height

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean isSymmetricFlag;
    public boolean isSymmetric(TreeNode root) {
        
        //base case
        if(root == null) return true;
        
        isSymmetricFlag = true;
        
        dfs(root.left, root.right);
        return isSymmetricFlag;
        
    }
    
    private void dfs(TreeNode left, TreeNode right)
    {
        //base case
        if(left == null && right == null) 
            return;
       if(left == null || right == null || left.val != right.val) // if one of the node is null then it will come here, so put this condition check in pre-order, else it will throw out of bound!
        {
            isSymmetricFlag = false;
            return;
        } 
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}

//approach -1 a - 
//copying approach -1 just not suing boolean flag and returning what function gives us!
//D-F-S
//TC- O(n)
//SC - O(h)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        //base case
        if(root == null) return true;
        
        return dfs(root.left, root.right);
        
    }
    
    private boolean dfs(TreeNode left, TreeNode right)
    {
        //base case
        if(left  == null && right == null) return true;
        
        if(left  == null || right == null || left.val != right.val)
            return false;
        
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}



//approach -2
//1. in-order traversal of tree
//2. store node values in list
//check if list is palindorme
//tc- O(n)
//sc- Max of (O(n), O(h) ) - recursive stack + list 

// this solution will not work for a tree like - [1,2,2,2,null,2]
/
/*                 1 
*        2                    2

2                       2
*/
//above tree is not symmetric as we left's right != right's left

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list;
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        
        list = new ArrayList<>();
        
        inOrder(root);
        
        if(list.size() <=1) return true;
        
        int low =0; 
        int high = list.size()-1;
        
        System.out.println(list);
        while(low<=high)
        {
            if(list.get(low) !=  list.get(high))
                return false;
             low++;
             high--;
        }
       
        return true;
    }
    
    private void inOrder(TreeNode root)
    {
        //base case
        if(root == null) 
        {
         return;   
        }
        
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}

//approach - 3
//iterativve
//BFS approach - level by level traversal
//add left's left and right's right, and check if they are equal, if not return false, 
//else check left's right and right's left and same logic!
//TC- O(n)
//SC - O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty())
        {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            
            if(left == null && right == null) continue;
            
            if(left == null  || right == null || left.val != right.val) return false;
            
            //following order matters for checking symmetricity. 
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}