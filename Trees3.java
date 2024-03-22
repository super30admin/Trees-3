//Symmetric trees Time compelexity O(N) and Space Complexity O(N)
class Solution {
    public boolean isSymmetric(TreeNode root) {

        return isMirror(root,root);
        
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){

        if(t1==null && t2==null) return true;
        if(t1==null || t2==null) return false;

        return t1.val==t2.val && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
}


//Time Complexity O(N2) and space complexity O(N)
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        result = new ArrayList<>();

        helper(root,new ArrayList<>(),0,targetSum);

        return result;
        
    
    }

    public void helper(TreeNode root, List<Integer> path, int sum,int targetSum){

        if(root==null) return;

        sum=sum+root.val;
        path.add(root.val);

        if(root.left==null && root.right==null && targetSum==sum){
            System.out.println(path);
            result.add(new ArrayList<>(path));
        }

        helper(root.left,path,sum,targetSum);
        helper(root.right,path,sum,targetSum);
        path.remove(path.size()-1);
    }
}
