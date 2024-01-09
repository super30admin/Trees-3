"""
Time Complexity : O(n) where n is the number of nodes in the tree. This o(n) because we are visitng every node of the tree once.
Space Complexity : O(h) where h is the height of the tree. In worst case it will be O(n) where n is the number of nodes in the tree.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
1. In the bruteforce approach we are creating new path list which were resulting in extra space.
2. To optimize the same, we can use backtracking. Action (Adding - root.val to path, Recurse - Calling the dfs function, backtrack - pop the root.val from the path)
3. This way there is no need to create a list and we can use the same list resulting in optimizing time required for deep copy and space for newly created list
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def __init__(self):
        self.result = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root == None:
            return self.result
        self.helper(root, 0, [], targetSum)
        return self.result

    def helper(self, root, current_sum, path, target):
        # base
        if root == None:
            return

        # logic
        current_sum += root.val
        path.append(root.val)
        if root.left == None and root.right == None:
            if current_sum == target:
                self.result.append(path[:])

        self.helper(root.left, current_sum, path, target)
        self.helper(root.right, current_sum, path, target)
        path.pop()
