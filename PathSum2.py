"""
Leetcode 113 - Path Sum II

This class finds all root-to-leaf paths in a binary tree where the sum of the values equals the targetSum.

Attributes
----------
result : List[List[int]]
    Stores all valid root-to-leaf paths whose sum equals targetSum.

targetSum : int
    The desired sum that each path must add up to.

Methods
-------
pathSum(root: TreeNode, targetSum: int) -> List[List[int]]
    Initializes the helper function to find all valid paths.

helper(root: TreeNode, pathSum: int, sol: List[int]) -> None
    Recursive DFS traversal to track the current path and its cumulative sum.
    Adds path to result if it reaches a leaf and the path sum matches targetSum.

Time Complexity: O(n^2)
    Each path is copied when a valid one is found. In worst-case, there are O(n) nodes per path.

Space Complexity: O(h)
    h = height of the tree, due to recursion stack + O(n) per result path.
"""
class TreeNode:
    def __init__(self, val=0, left=None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.result = []
        self.targetSum = 0
    
    def pathSum(self, root, targetSum):
        self.targetSum = targetSum
        self.helper(root, 0, [])
        return self.result
    
    def helper(self, root, pathSum, sol):
        if not root:
            return
        
        sol.append(root.val)
        pathSum += root.val
        
        if root.left == None and root.right == None:
            if self.targetSum == pathSum:
                self.result.append(sol[:])
        
        self.helper(root.left, pathSum, sol)
        self.helper(root.right, pathSum, sol)
        sol.pop()

from collections import deque

# Helper to build tree from level-order input
def buildTree(values):
    if not values:
        return None
    root = TreeNode(values[0])
    queue = deque([root])
    i = 1
    while queue and i < len(values):
        node = queue.popleft()
        if values[i] is not None:
            node.left = TreeNode(values[i])
            queue.append(node.left)
        i += 1
        if i < len(values) and values[i] is not None:
            node.right = TreeNode(values[i])
            queue.append(node.right)
        i += 1
    return root

if __name__ == "__main__":
    # Test Case 1
    vals1 = [5,4,8,11,None,13,4,7,2,None,None,5,1]
    target1 = 22
    root1 = buildTree(vals1)
    sol1 = Solution()
    print("Paths for targetSum = 22:", sol1.pathSum(root1, target1))  # [[5,4,11,2],[5,8,4,5]]

    # Test Case 2
    vals2 = [1,2,3]
    target2 = 5
    root2 = buildTree(vals2)
    sol2 = Solution()
    print("Paths for targetSum = 5:", sol2.pathSum(root2, target2))  # []

    # Test Case 3
    vals3 = [1,2]
    target3 = 0
    root3 = buildTree(vals3)
    sol3 = Solution()
    print("Paths for targetSum = 0:", sol3.pathSum(root3, target3))  # []
