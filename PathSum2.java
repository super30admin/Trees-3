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

/*
time complexity: O(n^2)
space: O(n)
*/

class Pair{
    TreeNode node;
    int sum;
    List<Integer> currList;
    Pair(TreeNode node, int sum, List<Integer> currList){
        this.node = node;
        this.sum  = sum;
        this.currList = currList;
    }
}

class pathSum2 {
    
    //global variables
    List<List<Integer>>result;
    //int sum;
    List<Integer> currList;
   
//      public List<List<Integer>> pathSum(TreeNode root, int sum){
//          if(root == null){
//              return result;
//          }
//          //recursive call 
//         helper(root,0);
        
//         return result;       
//      }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
         if(root == null){
            return new ArrayList<>();
        }
        
        //stack which has type pair
        //pair consist of root,root.val, currlist;
        
        Stack<Pair> stack = new Stack<>();

        result = new ArrayList<>();
        currList =  new ArrayList<>();
        int currSum =0;
        
        //iteraitve loop
        while(root != null || !stack.isEmpty() ){
            
            while(root != null){
                
                //adding current root value to current sum and pushing in stack 
                currSum += root.val;
                currList.add(root.val);
                stack.push(new Pair(root,currSum,currList));//ex: 5,5,[5] , 4,9,[5,4] etc
                root = root.left;
            }
            
            //once the root is null, pop the top pair from stack
            
            Pair p = stack.pop();
            root = p.node; // current root node
            int topsum = p.sum; //current sum 
            
            //check if the sum at this node is equal to the given target sum and also check if its a leaf node
            if(root.left == null && root.right == null) {           
                if (topsum == sum) {
                    result.add(new ArrayList<>(currList));
                    
                    //after adding to result list, remove the last added element
                    currList.remove(currList.size()-1);

                }
            } 
            else{
                //if we are here, this means the leaf sum condition is not satisfied, so remove the last added element
                
                currList.remove(currList.size()-1);
            }
           
            //also reset the currsum to previous value
            currSum = p.sum;
            root = root.right;

        }


        return result;
   
    }
}
    
    
//     private void helper(TreeNode root, int currSum){
//         if(root == null){
//             return;
//         } 
//         //add the current node value to the currlist
        
//         currList.add(root.val);
//         //add the curr node to currsum
//         currSum += root.val;       
        
       
//         //if currsum = sum and node is a leaf node then add this to result array
//         if(root.left == null && root.right == null){
//              if(currSum == sum){
//                   result.add(new ArrayList<>(currList));
//               }             
//             }
//             else{
//                 //try go for other nodes left and right
//                 helper(root.left,currSum);
//                 helper(root.right,currSum);
                
//             } 
        
//         //remove the last added element
        
//         currList.remove(currList.size()-1);
//     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
