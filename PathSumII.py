# TC = O(n) --  number of elements in the tree
# SC = O(h) --- h is length of stack


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        self.helper(root, 0, targetSum, [])
        return self.result

    def helper(self, root, cursum, targetsum, path):
        # action
        if root == None:
            return
        cursum += root.val
        path.append(root.val)
        if root.left == None and root.right == None:
            if cursum == targetsum:

                self.result.append(path[:])

        # recursion
        self.helper(root.left, cursum, targetsum, path)
        self.helper(root.right, cursum, targetsum, path)

        # Backtracking

        path.pop()
