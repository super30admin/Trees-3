#LC - 113. Path Sum II
#Time Complexity - O(n)
#Space Complexity - O(n)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, sun):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if not root:
            return []
        self.ans = []
        def helper(root,path,tsum,sun):
            if root:
                tsum = tsum + root.val
                path.append(root.val)
                if not root.left and not root.right:
                    if tsum == sun:
                        x = [i for i in path]
                        self.ans.append(x)
                helper(root.left,path,tsum,sun)
                helper(root.right,path,tsum,sun)
                path.pop()
        helper(root,[],0,sun)
        return(self.ans)