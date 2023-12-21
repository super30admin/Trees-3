//approach - 1
//recursive call to the tree, just do the sum in the method call, copy the previous path, and add root to oath every time
//it progresses
//TC- O(n) + O(n^2) == Asymptotic - O(n^2)
//O(n) - for visiting each node
//O(n^2) - copying 1 list to next list -O(n), we do it for n node's list - n*n =O(n^2)
//sc-O(h) - h new array list for height of the tree. 

class Solution {
    
    List<List<Integer>> result ;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    
        if(root == null) return new ArrayList<>();

        target = targetSum;
        result = new ArrayList<>();

        pathSumHelper(root, 0, new ArrayList<>());

        return result;
    }

    private void pathSumHelper(TreeNode root, int sum, List<Integer> path)
    {
        //base case
        if(root == null ) return;

        //add node to path
        path.add(root.val);

        //check leaf node
        if(root.left == null && root.right == null)
        {
            //add node to sum
            sum += root.val;
            if(sum == target)
                {
                    result.add(path);
                    return; //we already got to the leaf, why to make one more recursive call? so just return
                }
        }

        //go left
        pathSumHelper(root.left, 
        sum+root.val/**this just adds parent's value so we have to add the node itself when we go to the leaf node! */
        , new ArrayList<>(path));

        //go right
        pathSumHelper(root.right, 
        sum+root.val/**this just adds parent's value so we have to add the node itself when we go to the leaf node! */
        , new ArrayList<>(path));
        
        return;
    }
}


//approach -2

class Solution {
    
    List<List<Integer>> result ;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    
        if(root == null) return new ArrayList<>();

        target = targetSum;
        result = new ArrayList<>();

        pathSumHelper(root, 0, new ArrayList<>());

        return result;
    }

    private void pathSumHelper(TreeNode root, int sum, List<Integer> path)
    {
        //base case
        if(root == null ) return;

        //add node to path
        path.add(root.val);
        sum = sum + root.val;

        //check leaf node
        if(root.left == null && root.right == null)
        {
            //add node to sum
            // sum += root.val;
            if(sum == target)
                result.add(path);
        }

        //go left
        pathSumHelper(root.left, sum, new ArrayList<>(path));

        //go right
        pathSumHelper(root.right, sum, new ArrayList<>(path));
        
        return;
    }
}

/*************     OPTIMIZED- BACK TRACK   ********** */
//approach -3  BACK TRACKING
//TC - O(n)
//SC- O(h)
//back-tracking approach to optimize space from O(n^2) --creating every node's list , just one global list, O(n)!!

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
    
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root == null) return new ArrayList<>();
        
        result = new ArrayList<>();
        target = targetSum;
        
        pathSumHelper(root, 0, new ArrayList<>());
        return result;
    }
    
    private void pathSumHelper(TreeNode root, int sum, List<Integer> path)
    {
        //base case
        if(root == null) return ;
        
        /*ACTION*/
        //System.out.println("Sum = "+sum);
        //add node value to the path
        path.add(root.val);
        //leaf node
        if(root.left == null && root.right == null )
        {
            sum = sum +root.val;
            //System.out.println("leaf - Sum = "+sum);
            if(sum == target)
             {
               // System.out.println("Path added. "); 
                List<Integer> newPath = new ArrayList(path); //copying to new, cause result.add(reference to path), and path is updated, so copy and then pass new ref.
                // System.out.println("New --  "+newPath);
                result.add(newPath);
                // path.remove(path.size() -1);
                // return;
             }
        }
        
        /*RECURSE*/
        //go left
        pathSumHelper(root.left, sum+root.val, path);
        //go right
        pathSumHelper(root.right, sum+root.val, path);
        
        /*BackTrack*/
        path.remove(path.size() -1);
    }
}

//note -if we add  return statement at line 163, we have to add line 162 - path.remove(path.size() -1),
// cause we are returning from the pathSumHelper() call, and so last statement - at line 174 will not be executed. 
//so everytime at leaf, we have to remove node before returning , so last leaf node will be removed. 