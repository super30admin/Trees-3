# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:

    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        
        self.path = [] # Track Path
        self.result = [] # Store Result
        
        def helper(node=root, cur_sum = 0):
            
            ### Base Case
            if not node:
                return
            
            ### Logic
            
            # Update Current Sum and add processing node to the path
            cur_sum += node.val
            self.path.append(node.val)
            
            # If leaf and sum matches target sum, append to result
            if not (node.left or node.right) and cur_sum == targetSum:
                self.result.append(self.path[:])
            
            # Process Left and Right Sub Tree
            helper(node.left, cur_sum)
            helper(node.right, cur_sum)
            
            # We have traversed everything on and below this point. Now we go to parent so pop out of the list
            self.path.pop()
        
        helper()
        return self.result
                
### Complexity Analysis

# Time Complexity: O(N) --> N = number of nodes
# Space Complexity: O(H) --> H = height of tree (Recursive Stack + path array)