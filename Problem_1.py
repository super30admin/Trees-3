# Runs on Leetcode
# DFS

# Runtime - O(n)
# Memory - O(n)

class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if not root:
            return []
        
        self.final = []
        self.helper(root, [root.val], root.val, targetSum)
        return self.final
    
    def helper(self, root, temp, currentSum, targetSum):
        if root.left is None and root.right is None and currentSum == targetSum:
            self.final.append(temp)
            
        if root.left is not None:
            self.helper(root.left, temp + [root.left.val], currentSum + root.left.val, targetSum)
        
        if root.right is not None:
            self.helper(root.right, temp + [root.right.val], currentSum + root.right.val, targetSum)
