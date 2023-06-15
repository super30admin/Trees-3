'''
Problem: Path Sum 2
Time Complexity: O(n), where n is number of nodes
Space Complexity: O(h), height of the tree
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        used bactracking to get the path
        when leaf node encounter and sum is equal to target then add copy path to the result
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []

        def helper(root, sum, target, path):
            #base
            if root == None:
                return
            #logic
            sum+=root.val
            #action
            path.append(root.val)
            if root.left == None and root.right == None:
                if sum == target:
                    result.append(path[:])
            
            #recurse
            helper(root.left, sum, target, path)
            helper(root.right, sum, target, path)
            
            #backtrack action
            path.pop()

        helper(root, 0, targetSum, [])
        return result