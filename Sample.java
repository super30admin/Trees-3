// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Problem1 (https://leetcode.com/problems/path-sum-ii/)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        boolean flag=false;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                flag=true;
                break;
            }
        }
        if(!flag)
            return null;
        fast=head;
        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
        
    }
}


// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


//Problem2 (https://leetcode.com/problems/symmetric-tree/)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  return true;
        return helper(root.left,root.right);
        
    }
    private boolean helper(TreeNode left,TreeNode right)
    {
        if(left==null && right==null) return true;
        if(left==null || right==null || left.val!=right.val) return false;
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
