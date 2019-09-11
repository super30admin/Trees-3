/**
 * The time complexity is O(N) and the space complexity O(Height) where we store each element from the root to leaf in a linked list
 *
 * We use recursive approach, where we go till the leaf to check the path sum. If the path sum is equal to required sum we add the linked
 * list to the main linked list.
 *
 * Yes, the solution passed all the test cases.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    List<List<Integer>> retList;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        retList = new LinkedList<>();
        if(root==null){return retList;}
        checkPathSum(root,0,sum,new LinkedList<Integer>());
        return retList;

    }

    public void checkPathSum(TreeNode node,int currsum,int sum,List<Integer> list){


        currsum = currsum+node.val;
        list.add(node.val);

        if(node.left==null && node.right==null){
            if(currsum==sum){
                retList.add(new LinkedList<>(list));
            }
        }
        else{
            int listLength = list.size();

            if(node.left!=null){
                checkPathSum(node.left,currsum,sum,list);
                list.remove(listLength);
            }
            if(node.right!=null){
                checkPathSum(node.right,currsum,sum,list);
                list.remove(listLength);
            }

        }
    }



}