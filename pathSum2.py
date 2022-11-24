# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Time Complexity -->
O(n)

Space Complexity -->

O(h) where h is the height of the tree
'''
class Solution:
    def dfs(self, root, path, ans, remainingSum):
        # if it is None, then return
        if not root:
            return
        # add the current node val to path
        path.append(root.val)
        
        if not root.left and not root.right and remainingSum == root.val:
            ans.append(list(path))
        
        self.dfs(root.left, path, ans, remainingSum - root.val)
        
        self.dfs(root.right, path, ans, remainingSum - root.val)
        # backtrack 
        path.pop()
    
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        ans = []
        self.dfs(root, [], ans, targetSum)
        return ans