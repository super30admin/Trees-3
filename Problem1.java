//time o(n2)
//space o(n)

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
//     class Triplet {
//         TreeNode node;
//         int sum;
//         List<Integer> sumList;
    
//         Triplet(TreeNode node, int sum, List<Integer> sumList) {
//             this.node = node;
//             this.sum = sum;
//             this.sumList = sumList;
//         }
    
//         public TreeNode getNode() {
//             return node;
//         }
    
//         public int getSum() {
//             return sum;
//         }
    
//         public List<Integer> getList() {
//             return sumList;
//         }
//     }
//     List<List<Integer>> res = new ArrayList<>();
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         List<List<Integer>> res = new ArrayList<>();
//         Stack<Triplet> stack = new Stack<>();
//         int sum = 0;
//         List<Integer> list = new ArrayList<>();
//         while ( root!=null || !stack.isEmpty() ) {
            
//             while(root != null) {
//                 sum += root.val;
//                 list.add(root.val);
//                 List<Integer> temp = new ArrayList<Integer>(list);
//                 Triplet t = new Triplet(root,sum,temp);
//                 stack.push(t);
//                 root = root.left;
//             }
            
//             Triplet tVal = stack.pop();
//             root = tVal.getNode();
//             sum = tVal.getSum();
//             list = tVal.getList();
            
//             if(root.left == null && root.right == null && sum == targetSum) {
//                 res.add(list);
//             } 

//             root = root.right;
    
//         }
//         return res;
       
//     }
    
     List<List<Integer>> res = new ArrayList<>();
     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         helper(root, targetSum, new ArrayList<Integer>());
         return res;
     }
    
    public void helper(TreeNode root, int remainingSum, List<Integer> currList) {
      
        if(root == null) {
            return;
        }
       
        currList.add(root.val);
        remainingSum = remainingSum - root.val;
        
        if(root.right == null && root.left == null && remainingSum ==  0) {
            res.add(new ArrayList<Integer>(currList));
        } else {
             helper(root.left, remainingSum, currList);
             helper(root.right, remainingSum, currList);
        }
        
        // helper(root.left, targetSum, new ArrayList<Integer>(currList), currSum);
        // helper(root.right, targetSum, new ArrayList<Integer>(currList),currSum);
        
       
                
        currList.remove(currList.size() - 1);
        
    }  
    
}
