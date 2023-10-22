# TC : O(n)
# SC : O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if not root:
            return []
        
        result = []
        stack = [(root, [root.val], targetSum - root.val)]
        
        while stack:
            node, path, remainingSum = stack.pop()
            
            if not node.left and not node.right and remainingSum == 0:
                result.append(path)
            
            if node.left:
                stack.append((node.left, path + [node.left.val], remainingSum - node.left.val))
            
            if node.right:
                stack.append((node.right, path + [node.right.val], remainingSum - node.right.val))
        
        return result
