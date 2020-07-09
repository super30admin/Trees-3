# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def helper(self,rightnode,leftnode):
        # if right has a node but left don't or vise versa return false
        if (not rightnode and leftnode) or (not leftnode and rightnode):
            return False
        # if not right node oor left node return true
        elif not rightnode and not leftnode:
            return True
        # return value of both nodes = each other and recurse on right.right with left.left and right.left with left.right
        else:
            return rightnode.val == leftnode.val and self.helper(rightnode.right,leftnode.left) and self.helper(rightnode.left,leftnode.right)
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        else:
            return self.helper(root.right,root.left)
        