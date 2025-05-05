# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []
        self.result = []
        self.recurse(root, targetSum, [])
        return self.result

    def recurse(self, root, targetsum, path):
        # base case
        print(targetsum)
        if not root:
            return
        path.append(root.val)
        if targetsum - root.val == 0 and not root.left and not root.right:
            self.result.append(path.copy())
        # logic
        self.recurse(root.left, targetsum - root.val, path)
        self.recurse(root.right, targetsum - root.val, path)
        path.pop()
