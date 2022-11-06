# Time Complexity: O(n)
# Space Complexity: O(h) -> height of the tree
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        if not root:
            return
        
        self.result = []
        
        def helper(node, path):
            if not node:
                return
            
            if sum(path) == targetSum and node.left == None and node.right == None:
                self.result.append(list(path))
               
            if node.left:
                path.append(node.left.val)
                helper(node.left, path)

            if node.right:
                path.append(node.right.val)
                helper(node.right, path)
            path.pop()
        
        helper(root, [root.val])
        return self.result          