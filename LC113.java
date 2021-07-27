class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> currPath = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        
        recurr(root, sum, 0, currPath, output);
        return output;
    }
    
    private void recurr(TreeNode root, int target, int currSum, List<Integer> currPath, List<List<Integer>> output){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(currSum + root.val == target){
                List<Integer> temp = new ArrayList<Integer>(currPath);
                temp.add(root.val);
                
                output.add(temp);
            }
            return;
        }
        currPath.add(root.val);
        
        recurr(root.left, target, currSum + root.val, currPath, output);
        recurr(root.right, target, currSum + root.val, currPath, output);
        
        currPath.remove(currPath.size() - 1);
    }
    }