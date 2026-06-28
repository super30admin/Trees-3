## Problem1 (https://leetcode.com/problems/path-sum-ii/)
import copy

class Solution:
    # Time Complexity: O(N) 
    # Why: We visit every node in the tree exactly once during the DFS traversal, 
    # where N is the total number of nodes. 
    # (Note: In the worst-case scenario where a large number of valid paths are found, 
    # copying the path to the result list could push the time closer to O(N^2), 
    # but the core traversal itself is strictly O(N)).
    #
    # Space Complexity: O(H) auxiliary space, where H is the height of the tree.
    # Why: By utilizing backtracking, we only maintain a single list (`nodesInPath`) 
    # rather than creating new lists at every step. The memory used is defined by the 
    # maximum depth of the recursion stack and our path list, which is at most the 
    # height of the tree. 
    #   - Best/Average Case (Balanced Tree): O(log N)
    #   - Worst Case (Skewed Tree): O(N)
    
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        
        # Helper function to perform Depth First Search (DFS) with backtracking
        def helper(node, currentSum, nodesInPath):
            nonlocal targetSum, result
            
            # Base case: if the current node is null, stop exploring this branch
            if node == None:
                return

            # Include the current node's value in our running total
            currentSum += node.val
            
            # Add the current node to our path tracking list
            nodesInPath.append(node.val)
            
            # Check if this is a leaf node AND if the running sum matches our target
            if node.left == None and node.right == None and currentSum == targetSum:
                # Valid path found! We must append a copy of `nodesInPath` to the 
                # result array. If we didn't copy it, subsequent modifications to 
                # `nodesInPath` during backtracking would alter the saved result.
                result.append(copy.deepcopy(nodesInPath))

            # Recursively search the left and right subtrees
            helper(node.left, currentSum, nodesInPath)
            helper(node.right, currentSum, nodesInPath)
            
            # BACKTRACKING STEP:
            # We are done exploring both subtrees for the current node. 
            # We remove (pop) the current node's value from `nodesInPath` before 
            # returning up the call stack, so the parent node can explore its 
            # other branches with a clean slate.
            nodesInPath.pop()

        # Kick off the traversal starting at the root
        helper(root, 0, [])
        
        return result