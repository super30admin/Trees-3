// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Problem1 {
    List<List<Integer>> result ;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        //helper(root,targetSum,0,new ArrayList<>());
        helperBackTrack(root,targetSum,0,new ArrayList<>());
        return result;
    }
    // TC O(N^2) n for path copying for each visited node ie.. n times n
    //SC: O(N^2)
    void helper(TreeNode root,int targetSum,int curSum,List<Integer> path){
        if(root == null){
            return ;
        }

        List<Integer> newPath = new ArrayList<>(path);
        curSum+=root.val;
        newPath.add(root.val);
        if(root.left == null && root.right == null){
            //only for the leaf nodes we have to dd it as the result
            if(curSum == targetSum){
                this.result.add(newPath);
            }
        }

        helper(root.left,targetSum,curSum,newPath);
        helper(root.right,targetSum,curSum,newPath);
    }

    // TC O(N^2) n for path copying for each visited node ie.. n times n
    //SC: O(N^2)
    void helperBackTrack(TreeNode root,int targetSum,int curSum,List<Integer> path){
        if(root == null){
            return ;
        }


        curSum+=root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            //only for the leaf nodes we have to dd it as the result
            if(curSum == targetSum){
                this.result.add(new ArrayList<>(path));
            }
        }

        helperBackTrack(root.left,targetSum,curSum,path);
        helperBackTrack(root.right,targetSum,curSum,path);

        //back track
        path.remove(path.size()-1);
    }
}