# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.results = []

    """
    Exhaustive appproach: create a list at every node
    TC - O(n^2)
    SC - O(n^2)
    """

    def approach1(self, root, targetSum, path):
        if root == None:
            return
        path.append(root.val)
        if root.left == None and root.right == None:
            if targetSum - root.val == 0:
                self.results.append(path)
        self.approach1(root.left, targetSum - root.val, path.copy())
        self.approach1(root.right, targetSum - root.val, path.copy())

    """
    Backtracking approach: maintaing one list
    TC - O(n)
    SC - O(n^2)
    """

    def approach1(self, root, targetSum, path):
        if root == None:
            return
        path.append(root.val)
        if root.left == None and root.right == None:
            if targetSum - root.val == 0:
                self.results.append(path.copy())
        self.approach1(root.left, targetSum - root.val, path)
        self.approach1(root.right, targetSum - root.val, path)
        path.pop()

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root == None:
            return []
        self.approach2(root, targetSum, [])
        return self.results
