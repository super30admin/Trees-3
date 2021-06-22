#Time complexity: O(n)   
#Space complexity: O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        # Void recursion
        self.result = True
        if root is None:
            return self.result
        def helper(root1,root2):
            #base
            # if one of them is None, then not mirror
            if (root1 is None and root2 is not None) or (root1 is not None and root2 is None):
                self.result = False
                return
            #if both are none, then mirror
            if root1 is None and root2 is None:
                return
            # if the root value of the tree is not same, not mirror
            if root1.val != root2.val:
                self.result = False
                return
            #recurse
            # mirror has lateral inversion, i.e. the reason for comparing root1 left and root2 right
            helper(root1.left,root2.right)
            helper(root1.right,root2.left)
        # when the first call, both left tree and right tree are equal
        helper(root,root)
        return self.result