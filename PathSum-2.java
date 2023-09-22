lass Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        Inorder(root,path,0,targetSum);
        return result;
    }

    private void Inorder( TreeNode root, List<Integer> path, int CurrSum, int target){
        if(root == null) return;
         
         
         CurrSum = CurrSum + root.val;
         //action
         path.add(root.val);
         //recurse
        Inorder(root.left,path,CurrSum,target);
        if(root.left == null && root.right == null){
            if(CurrSum == target){
                result.add(new ArrayList<>(path));
            }
        }
        Inorder(root.right, path, CurrSum, target);
         //backtracking
        path.remove(path.size()-1);
    }
}



/**

TC : O(n^2) --> we are also copying nodes inside the list every time.

SC : O(n^2) --> Here Stack size is 'n' and als0 forming List at every time so 'n' number of lists.



Description : In BruteForce we are creating new list everytime, by this we can avoid the updation of list in all places when we use Single list. A DS inside a DS is always a pointer. So only reference id will sore inside recursive stack 




 */