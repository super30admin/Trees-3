# Timel O(n)
# Space: O(nh)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    result = []
    def pathSum(self, root, targetSum):
        self.result = []
        self.helper(root, targetSum, 0, [])
        return self.result
    
    def helper(self, root, targetSum, currSum, path):
        if root is None:
            return
        path2 = []
        path2 += path
        path2.append(root.val)
        currSum += root.val
        if root.left is None and root.right is None and currSum == targetSum:
            self.result.append(path2)
        
        self.helper(root.left, targetSum, currSum, path2)
        self.helper(root.right, targetSum, currSum, path2)
        
        
######## Better solution:
# time: O(n)
# space: O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    result = []
    def pathSum(self, root, targetSum):
        self.result = []
        self.helper(root, targetSum, 0, [])
        return self.result
    
    def helper(self, root, targetSum, currSum, path):
        if root is None:
            return
        path.append(root.val)
        currSum += root.val
        if root.left is None and root.right is None and currSum == targetSum:
            path2 = []
            path2 += path
            self.result.append(path2)
        
        self.helper(root.left, targetSum, currSum, path)
        self.helper(root.right, targetSum, currSum, path)
        path.pop()
        