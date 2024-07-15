# time: O(n)
# space: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res = []
    def helper(self, root, cursum, target, path):
        if root==None:
            return
        
        cursum+=root.val
        path.append(root.val)
        self.helper(root.left, cursum, target, path)

        if(root.left==None and root.right==None):
            if cursum==target:
                self.res.append(path.copy())

        
        self.helper(root.right, cursum, target, path)

        path.pop()


    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        self.res = []
        self.helper(root, 0, targetSum, [])
        return self.res