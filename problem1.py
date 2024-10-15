# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
Approach:
- The solution uses Depth-First Search (DFS) to explore all paths from the root to the leaf nodes.
- At each node, we add the node's value to the current path sum and append the node to the current path list.
- If we reach a leaf node and the current path sum equals the target sum, we append a copy of the current path to the result.
- After exploring both left and right subtrees, we backtrack by removing the current node from the path and subtracting its value from the current sum.

Time Complexity (TC):
- In the worst case, we visit each node exactly once. For each leaf node, we create a copy of the path.
- Therefore, the time complexity is O(N), where N is the number of nodes in the tree.

Space Complexity (SC):
- The space complexity is O(H), where H is the height of the tree, due to the recursive call stack.
- In the worst case (skewed tree), H can be O(N). In the best case (balanced tree), H is O(log N).
- Additional space is used for storing the current path, which in the worst case can also be O(H).
"""

class Solution(object):
    def pathSum(self, root, targetSum):
        res = []
        curSum = 0
        curPath = []

        def dfs(root, res, curSum, curPath, targetSum):
            if not root:
                return None

            curSum += root.val
            curPath.append(root.val)

            if not root.left and not root.right and curSum == targetSum:
                res.append(curPath[:])

            dfs(root.left, res, curSum, curPath, targetSum)
            dfs(root.right, res, curSum, curPath, targetSum)

            curSum -= root.val
            curPath.pop()

        dfs(root, res, curSum, curPath, targetSum)
        return res
