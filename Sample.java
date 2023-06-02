class Solution {
    List<List<Integer>> result;
    int tar;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root == null) return result;        
        tar = targetSum;
        DFS(root,0,new ArrayList<>());
        return result;
    }
    
    private void DFS(TreeNode root, int sum, List<Integer> path){
        //base
        if(root == null) return;
        
        //logic
            //Action
        path.add(root.val);
        sum += root.val;
        
            //Recursion
        DFS(root.left, sum, path);
        
        if((root.left == null && root.right == null) && (sum == tar)){
            
            result.add(new ArrayList<>(path));
        }     
        
        DFS(root.right, sum, path); 
            //Backtrack
        path.remove(path.size()-1);
    }
    
    
}


class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        Stack<TreeNode> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while(!st.isEmpty()){
            TreeNode right = st.pop();
            TreeNode left = st.pop();
            if(left == null && right == null)continue;
            if(left == null && right !=null)return false;
            if(left != null && right ==null)return false;
            if(left.val != right.val)return false;
            st.push(left.left);
            st.push(right.right);
            st.push(left.right);
            st.push(right.left);

        }
        return true; 
    }
}//iterative solution
