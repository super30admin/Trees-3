# Time Complexity: O(n) 
# Space Complexity: O(h) - height of tree
# Approach:
# Use a top down dfs approach. 
# Pass along the nodes seen so far and the sum of the nodes as parameters to the recursive function.
# At every node, accumulate the pathsum.
# At every leaf node, check if the path sum is equal to desired sum, if it is, append the nodes collected so far to the result.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum1):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if not root:
            return []
        result = []
        
        def dfs(node, slate, slatesum):
            # Compute sum and collect nodes
            slatesum += node.val
            slate.append(node.val)
            
            # Base Case - Leaf Node
            if node.left is None and node.right is None:
                if slatesum == sum1: # Check if sum is equal to desired sum, append nodes to result
                    # Append a deep copy of the slate
                    result.append(slate[:])
            
            # Recursive Case
            if node.left:
                dfs(node.left, slate, slatesum)
            if node.right:
                dfs(node.right, slate, slatesum)
                
            # Pop out the node, since we are using a mutable slate(list) to collect results, we have to clean or undo the work done prior to the recursive call.
            slate.pop()
                
        dfs(root, [], 0)
        return result
