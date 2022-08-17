

//TC: O(n)
//SC:O(h)

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //create a list of list for result
       List<List<Integer>> res = new ArrayList<>();
        //create a list for holding the currPath at each recursion
        List<Integer> curPath = new ArrayList<>();
        
        //create a helper function and pass root, curSum, targetSum , curPath and result
        helper(root,0,targetSum,curPath,res);
        
        return res;
    }
    
    private void helper(TreeNode root, int curSum, int targetSum, List<Integer> curPath, List<List<Integer>> res){
        
        //base case
        if(root==null){
            return;
        }
        //action
        curPath.add(root.val);
        curSum = curSum+root.val;
        if(root.right==null&&root.left==null){
            if(curSum==targetSum){
                res.add(new ArrayList<>(curPath));
            }
        }
        
        //recurse
         helper(root.left,curSum,targetSum,curPath,res);
         helper(root.right,curSum,targetSum,curPath,res);
        
        //backtrack
        curPath.remove(curPath.size()-1);
        
        
    }
}

//---brute force
//sc- O(n) - every node creating a list (n) i.e O(n*h)
//tc: O(n^2) --n*h -- deep copy of path list at every node at every recursion
// class Solution {
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         List<List<Integer>> res = new ArrayList<>();
//         helper(root, 0 , targetSum, new ArrayList(), res); 
//         return res; 
//     }
    
//     private void helper(TreeNode root,int curSum, int targetSum,List<Integer> curPath, List<List<Integer>> res){
        
//         if(root == null){
//             return;
//         }
        
//         curSum = curSum+root.val;
//         curPath.add(root.val);
//         if(root.left==null && root.right==null){
//             if(curSum == targetSum){
//                 res.add(curPath);
//             }
//         }
//         //ArrayList<Integer>(curPath) -- creating a new arraylist of curPath for each recurrsion 
//         helper(root.left, curSum, targetSum, new ArrayList<Integer>(curPath), res);
//         helper(root.right,curSum, targetSum, new ArrayList<Integer>(curPath), res);
        
//     }
    
// }
