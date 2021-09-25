//time complexity: O(n)
//space complexity: O(h)

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList(); //creating an arraylist

      if (root == null) { //initial check base condition
         return result;
      }

      getPath(root, new ArrayList(), result, targetSum); //recursive call to get result
      return result;
   }

   public void getPath(TreeNode root, List<Integer> sub, List<List<Integer>> result, int sum) {
      if (root == null) { //initial check
         return;
      }

      if (root.left == null && root.right == null && sum == root.val) { //leaf node check
         sub.add(root.val); //add it to the list
         result.add(new ArrayList(sub)); //add to the result 
      } else {
         sub.add(root.val); 

         if (root.left != null) {
            getPath(root.left, sub, result, sum - root.val); //left recursive call
            sub.remove(sub.size() - 1);
         }

         if (root.right != null) {
            getPath(root.right, sub, result, sum - root.val); //right recursive call
            sub.remove(sub.size() - 1);
         }
      }

   }
}