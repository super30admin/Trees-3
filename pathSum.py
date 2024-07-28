# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        # If the tree is empty, return an empty list.
        if root is None:
            return []

        self.result = []  # To store all the valid paths
        self.dfs(root, 0, [], targetSum)  # Start the depth-first search
        return self.result

    def dfs(self, root: Optional[TreeNode], currSum: int, path: List[int], targetSum: int):
        if root is None:
            return
        
        # Add the current node's value to the running sum and the current path
        currSum += root.val
        path.append(root.val)
        
        # Check if we have reached a leaf node and if the path sums up to the target sum
        if root.left is None and root.right is None:
            if currSum == targetSum:
                self.result.append(path[:])  # Append a copy of the current path to the result
        
        # Continue the search in the left and right subtrees
        self.dfs(root.left, currSum, path, targetSum)
        self.dfs(root.right, currSum, path, targetSum)
        
        # Backtrack: remove the current node from the path before returning
        path.pop()

# Time Complexity: O(n), where n is the number of nodes in the tree. 
# Space Complexity: O(h), where h is the height of the tree.


############# Method 2 ##############
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        # If the tree is empty, return an empty list.
        if root is None:
            return []

        self.result = []  # To store all the valid paths
        self.dfs(root, 0, [], targetSum)  # Start the depth-first search
        return self.result
    
    def dfs(self, root: Optional[TreeNode], currSum: int, path: List[int], targetSum: int):
        if root is None:
            return
        
        # Add the current node's value to the running sum and the current path
        currSum += root.val
        path.append(root.val)
        
        # Check if we have reached a leaf node and if the path sums up to the target sum
        if root.left is None and root.right is None:
            if currSum == targetSum:
                self.result.append(path)  # Append the current path to the result
        
        # Recursively call dfs on the left and right subtrees
        self.dfs(root.left, currSum, [i for i in path], targetSum)
        self.dfs(root.right, currSum, [i for i in path], targetSum)

# Time Complexity: O(n), where n is the number of nodes in the tree.
# This is because each node is visited exactly once during the depth-first search.

# Space Complexity: O(n^2), in the worst case. This is because:
# 1. The maximum depth of the recursion stack will be equal to the height of the tree, which can be up to O(n) in the worst case (for a skewed tree).
# 2. At each node, a copy of the current path is created and passed to the recursive calls, leading to O(n) space for each node in the path.
# Therefore, the overall space complexity is O(n^2).

