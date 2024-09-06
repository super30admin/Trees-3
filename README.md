# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)

## Problem2 (https://leetcode.com/problems/symmetric-tree/)

class Solution {

    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;
        if(root == null) return result;
        dfs(root, 0, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int currSum, List<Integer> temp){

        // Base 
        if(root == null) return;
        currSum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(target == currSum){
                result.add(new ArrayList<>(temp));
            }
        }
        // logic
        dfs(root.left, currSum, temp);
        dfs(root.right, currSum, temp);
        // backtrack
        temp.remove(temp.size() - 1);
    }
}


class Solution {

    List<List<Integer>> ls;

    int summ=0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        summ=sum;

        List<Integer> sl= new ArrayList<Integer>();

        int number=0;

        ls = new ArrayList<List<Integer>>();

        helper(root,number,sl);

        return ls;

    }

    void helper(TreeNode root, int number,List<Integer> sl )

    {

        if(root==null)

        {

            return;

        }

        sl.add(root.val);

        number+=root.val;

        if(root.left==null&&root.right==null)

        {

            if( number==summ)

            {

                    ls.add(sl);

            }

        }

        helper(root.left,number,new ArrayList<>(sl));

        helper(root.right,number,new ArrayList<>(sl));

        return;

    }

}