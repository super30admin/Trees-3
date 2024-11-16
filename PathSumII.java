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
 // Approach : Brute Force - Recursion. 
 // Time : o(h*n) 
 // Space : o(h*n) // o(n*h) // creating a list of size h + o(h) // recursive stack size
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root==null) return new ArrayList<>();
        this.result = new ArrayList<>();
        helper(root,targetSum,0,new ArrayList<>());
        return result;

        
    }
    public void helper(TreeNode root, int targetSum, int currSum , List<Integer> path){
        // base case
        if(root==null) return;

        // logic
        List<Integer> list = new ArrayList<>(path); 
        // Creates List at new location and all the 
        // elements of previous path will be copied to new list ----> deep copy
        currSum += root.val;
        list.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                System.out.println(list);
                result.add(list);
            }
        }

        // recursion
        helper(root.left,targetSum, currSum,list);
        helper(root.right,targetSum, currSum,list);
    }
}


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
 // Approach : improved recursion. 
 // Time : o(h*n) 
 // Space : o(h*n) // o(n*h) // creating a list of size h + o(h) // recursive stack size
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root==null) return new ArrayList<>();
        this.result = new ArrayList<>();
        helper(root,targetSum,0,new ArrayList<>());
        return result;

        
    }
    public void helper(TreeNode root, int targetSum, int currSum , List<Integer> path){
        // base case
        if(root==null) return;

        // logic
        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                System.out.println(path);
                result.add(path);
            }
        }
        // recursion
        helper(root.left,targetSum, currSum,new ArrayList<>(path));
        helper(root.right,targetSum, currSum,new ArrayList<>(path));
    }
}



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

// Approach : BackTrack. 
// Time : o(h*n) 
// Space : o(h*n) // o(n*h) // creating a list of size h + o(h) // recursive stack size
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        this.result = new ArrayList<>();
        helper(root,targetSum,0,new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root,int targetSum , int currSum, List<Integer> path){
        // Base case
        if(root == null) return;

        // Logic
        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                List<Integer> list = new ArrayList<>(path); 
                // if not done after full recursion all elements will be popped out because of recurison
                result.add(list);
            }
        }

        // Recursion
        helper(root.left,targetSum,currSum,path);
        helper(root.right,targetSum,currSum,path);

        // backtrack -> only after both the babies are visited
        path.remove(path.size()-1); // lastly added element
    }
}