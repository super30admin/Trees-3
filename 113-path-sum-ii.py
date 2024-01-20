
"""
113. Path Sum II
Medium
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
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

 
Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000


"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Accepted
    Time Complexity: O(n)
    Space Complexity: O(h) where h is the height of the tree
    
    Explanation: Traveerse the tree in DFS fashion and keep track of a sum variable adding all the visited nodes.
        We, also need to track the path.
        Now, we need to check the sum at each leaf node and if it matches the targetSum then we need to add the path to the result.
        
    """
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        path = []
        def helper(root, sum):
            if root is None: 
                return
            sum += root.val
            path.append(root.val)
            if sum == targetSum and root.left is None and root.right is None: # Found the sum at a leaf node
                res.append(path.copy())
            # Recurse
            helper(root.left, sum) 
            helper(root.right, sum)
            # clean up || Backtracking 
            tmp = path.pop()
            sum -= tmp
            return
        helper(root, 0)
        return res

LeetCode(PROBLEM, Solution).check()
