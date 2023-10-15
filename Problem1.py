'''
1. When we reach the child node, we check if the sum of the path is equal to the target sum.
2. If it is, we add the path to the ans list.
3. We do this recursively for both the left and right child appending the current node to the path and adding the current node's value to the current sum.

TC: O(n)
SC: O(n) - recursive stack
'''
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
        self.ans = []
        self.dfs(root,[],targetSum,0)
        return self.ans

    def dfs(self,root: TreeNode,path: List[int], target: int,cursum: int):
        # Base
        if root == None:
            return

        #logic
        if root.left == None and root.right == None and cursum + root.val == target:
                self.ans.append(path + [root.val])
                return

        self.dfs(root.left,path + [root.val], target, cursum + root.val)
        self.dfs(root.right, path + [root.val], target, cursum + root.val)

        