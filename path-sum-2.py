# Time Complexity: O(n^2) as we are deepcopying the path whenever we reach the target sum.
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """
        res=[]
        cpath=[]
        def helper(root,csum):
            if root==None:
                return
            cpath.append(root.val)
            csum+=root.val
            if root.left==None and root.right==None:
                if csum==targetSum:
                    res.append(cpath[:])
            
            helper(root.left,csum)
            helper(root.right,csum)

            cpath.pop(-1)
        
        helper(root,0)
        return res