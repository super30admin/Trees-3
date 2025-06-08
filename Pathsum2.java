//Solved successfully on leetcode and faced no issues
//TC : O(n^2) SC : O(H)


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetsum) {
        List<List<Integer>>output = new ArrayList<>();
        List<Integer>path = new ArrayList<>();

        helper(root ,  targetsum ,output , path);
        return output;
    }
    private void helper(TreeNode root , int targetsum , List<List<Integer>>output , List<Integer>path){
        if(root == null){
            return;
        }
         path.add(root.val);
         if(root.left == null && root.right == null && root.val == targetsum){
            output.add(new ArrayList<>(path));
        }

        else{
            helper(root.left , targetsum - root.val ,  output , path);
             helper(root.right , targetsum - root.val , output , path);
        }
        path.remove(path.size()-1);



    }
}