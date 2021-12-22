public class Problem1 {
    //Path Sum 2
    //Brute Force Way
    //Time complexity : o(n^2)
    //Space complexity : o(n^2)
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result= new ArrayList<>();
        dfs(root,targetSum,0, new ArrayList<>());
        return result;
    }
    
    private void dfs(TreeNode root, int targetSum, int currentSum,List<Integer> list){
        if(root==null){
            return;
        }   
        
         currentSum+=root.val;
         list.add(root.val);
            if(root.left==null && root.right==null){
                if(currentSum==targetSum){
                result.add(list);
            }
        }
        dfs(root.left,targetSum,currentSum,new ArrayList<>(list));
        dfs(root.right,targetSum,currentSum,new ArrayList<>(list));

    }

    //Optimized way
    //Time complexity : o(n)     
    //Space complexity : o(h) 
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result= new ArrayList<>();
        dfs(root,targetSum,0, new ArrayList<>());
        return result;
    }
    
    private void dfs(TreeNode root, int targetSum, int currentSum,List<Integer> list){
        if(root==null){
            return;
        }   
         //Action
         currentSum+=root.val;
         list.add(root.val);
            if(root.left==null && root.right==null){
                if(currentSum==targetSum){
                result.add(new ArrayList<>(list));
            }      
        }
        //Recurse
        dfs(root.left,targetSum,currentSum,list);
        dfs(root.right,targetSum,currentSum,list);
        
        //BackTrack
        list.remove(list.size()-1);

    }
}
