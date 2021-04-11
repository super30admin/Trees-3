## Problem1 (https://leetcode.com/problems/path-sum-ii/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        self.final_path_list = []
        self.targetSum = targetSum
        if root is None:
            return self.final_path_list
        self.solve(root,[root.val],root.val)

        return self.final_path_list

    def solve(self,node, path_list, path_sum):
        if node is None:
            return

        if node.left is None and node.right is None:
            if path_sum == self.targetSum:
                self.final_path_list.append(path_list.copy())
            return

        if not node.left is None:
            self.solve(node.left,path_list+[node.left.val],path_sum+node.left.val)

        if not node.right is None:
            self.solve(node.right,path_list+[node.right.val],path_sum+node.right.val)
        
        #Time Complexity: O(n)
        #Space Complexity: O(1) 