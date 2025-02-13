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
class PathSumII {
    List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            
            List<Integer> path = new ArrayList<>();
            helper(root,path,0,targetSum);
            return res;
        }
    
        public void helper(TreeNode root, List<Integer> path, int cursum, int target)
        {
                if(root==null)
                return;
                cursum+=root.val;
                path.add(root.val);
    
                if(root.left == null && root.right==null)
                {
                    if(cursum==target)
                    {
                        res.add(new ArrayList(path));
                    }
                    
                }
    
                helper(root.left,path,cursum,target);
                helper(root.right,path,cursum,target);
                path.remove(path.size()-1);
        }
    }


//Time Complexity (TC): O(n×h)
//Space Complexity (SC): O(n×h)

