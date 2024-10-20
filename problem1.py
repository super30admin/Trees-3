# time complexity: O(n)
# Space complexity: O(h) where h is the height of the tree
# Approach: Traverse the tree in a DFS manner and keep track of the path sum. If the path sum matches the target sum and the node is a leaf node, add the path to the result. If the path sum doesn't match the target sum or the node is not a leaf node, backtrack. Return the result.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def helper(node, sum, stack):
            if not node:
                return
            
            sum += node.val
            stack.append(node.val)
            
            # If it's a leaf node and the sum matches the target
            if not node.left and not node.right and sum == targetSum:
                result.append(stack[:])
                stack.pop()
                return
            
            helper(node.left, sum, stack)
            helper(node.right, sum, stack)
            
            # Backtrack
            stack.pop()
        
        result = []
        helper(root, 0, [])
        return result