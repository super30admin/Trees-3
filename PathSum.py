#TC: O(n)
#SC: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    global paths
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None:
            return []
        self.paths=[]
        self.helperFunction(root,root.val ,targetSum, [root.val])
        return self.paths
    def helperFunction(self,root, actualsum, target, path):
        if not root.left and not root.right:
            if actualsum==target:
                self.paths.append(path)
            return
        if root.left:
            self.helperFunction(root.left, actualsum+root.left.val, target, path+[root.left.val])
        if root.right:
            self.helperFunction(root.right, actualsum+root.right.val, target, path+[root.right.val])