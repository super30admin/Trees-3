"""
Time Complexity : O(n^2) where n is the number of nodes in the tree. O(n) required for visiting every tree node and additional o(n) is required for deep copy
Space Complexity : O(n^2) where n is the number of nodes in the tree. O(n) for recursive stack and additional O(n) for the list created for each node

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
1. Data structure inside a data structure is a reference.
2. So if we do not create a separate list for every node, at the end the all the elements will be preseneted in the result list as we are making changes to the same reference/list
3. For every node we will maintain three local things, root, currentSum and its associated path
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
        if root.left == None and root.right == None:
            if current_sum + root.val == target:
                path.append(root.val)
                self.result.append(path)
                return
        # logic
        current_sum += root.val
        path.append(root.val)
        self.helper(root.left, current_sum, path[:], target)
        self.helper(root.right, current_sum, path[:], target)
