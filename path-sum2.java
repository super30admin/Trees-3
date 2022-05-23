//Time Complexity: O(n)
//Space Complexity:o(1)
//Did this code successfully run on Leetcode :Yes

class treeNode
{
    int value;
    treeNode left , right;
    public treeNode(int x)
    {
        value = x;
        left = right = null;
    }
}
class path_sum
{
    public static boolean pathSumEqualToTarget(treeNode root , int target)
    {
        if(root == null)
            return false;
        if(root.value == target && root.left == null && root.right == null)
            return true;
        return pathSumEqualToTarget(root.left , target - root.value) || pathSumEqualToTarget(root.right , target - root.value);
    }
    public static void main(String args[])
    {
        treeNode root = new treeNode(2);
        root.left = new treeNode(1);
        root.right = new treeNode(4);
        root.right.left = new treeNode(1);
        root.right.right = new treeNode(4);
        int K = 7;
        if(pathSumEqualToTarget(root , K))
            System.out.println("Path Present");
        else
            System.out.println("No such path");
    }
}