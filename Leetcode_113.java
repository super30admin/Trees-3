//way1
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
 //Travel to every node.
 //At every level, add the element to list path. 
 //Remove the root val from the targetSum
 //Once the leaf nodes are reached, check if targetSum is 0. if yes, add to result
 //TC: O(n)+O(h) h->height of tree, SC:O(h)
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();

        pathS(root,targetSum,path,res);
        return res;
    }

    private void pathS(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res){
        if(root==null){
            return ;
        }

        path.add(root.val);
        targetSum-=root.val;

         if(root.left==null && root.right==null){
            if(targetSum==0){
                res.add(new ArrayList<>(path));
            }
        }

        pathS(root.left,targetSum,path,res);

        pathS(root.right,targetSum,path,res);

        path.remove(path.size()-1);


    }
}

//way2
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
 //Travel to every node.
 //At every level, add the element to list path. 
 //Remove the root val from the targetSum
 //Once the leaf nodes are reached, check if targetSum is 0. if yes, add to result
 //TC: O(n^2)+O(h) h->height of tree, SC:O(n^2)
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();

        pathS(root,targetSum,path,res);
        return res;
    }

    private void pathS(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res){
        if(root==null){
            return ;
        }

        path.add(root.val);
        targetSum-=root.val;

         if(root.left==null && root.right==null){
            if(targetSum==0){
                res.add(path);
            }
        }

        pathS(root.left,targetSum,new ArrayList<>(path),res);

        pathS(root.right,targetSum,new ArrayList<>(path),res);


    }
}
