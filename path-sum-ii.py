"""

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. 
Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example 1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

Example 2:

Input: root = [1,2,3], targetSum = 5
Output: []

Example 3:

Input: root = [1,2], targetSum = 0
Output: []

Time Complexity: O(N), where N is the number of nodes, since we visit each node once.
Space Complexity: O(H), where H is the height of the tree, due to the recursive call stack (O(log N) for balanced trees, O(N) for skewed trees).

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# Used Depth-First Search (DFS) to traverse the binary tree while keeping track of the current sum and path. 
# If reached to a leaf node and the current sum equals the targetSum, added the path to the result list. 
# and backtrack by removing the last node from the path after exploring both left and right subtrees.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        res = []

        def dfs(cur, num, path):
            if not cur:
                return

            path.append(cur.val)
            num += cur.val

            if not cur.left and not cur.right and num == targetSum:
                res.append(list(path))

            dfs(cur.left, num, path)
            dfs(cur.right, num, path)

            path.pop()

        dfs(root, 0, [])

        return res

