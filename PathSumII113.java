import java.util.*;
//time complexity :  O(n)
//space complexity :  N(logN) ... N is for the LinkedList, log n is for recurssion stack
//  leet code execution : successfull
// steps: each path is computed against the targeted sum using runningSum, this was done by computing sum till the last leaf node on the left sub tree and right subtree in inorder traversal. Once running sum matches against targeted sum all the root elements in stack of deep copied(using another list) to result list.
class PathSumII113{

    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int x){
            this.val = x;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        helper(result,stack,root,sum,0);
        return result;
    }

    private void helper(List<List<Integer>> result, LinkedList<Integer> stack, TreeNode root, int sum, int runningSum) {
    
    if(root==null) return ;

    if(root.left==null &&root.right==null){
        if(runningSum+root.val==sum){
            stack.add(root.val);
            LinkedList<Integer> trace = new LinkedList<>();
            for(int i : stack){
                trace.add(i);
            }
            result.add(trace);
            stack.removeLast();
        }
    }
    
    if(root.left!=null){
        stack.add(root.val);
        helper(result, stack, root.right, sum, runningSum+root.val);
        stack.removeLast();
    }

    if(root.right!=null){
        stack.add(root.val);
        helper(result, stack, root.left, sum, runningSum+root.val);
        stack.removeLast();
    }
    }


}