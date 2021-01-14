# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Iterative Approach. Using stack if there is a root append the root, sum-rootval, path onto the stack
# Then check if root is a leaf node or it has left and right child.
# For the left child, append the left, sum-left and path and same for right child
# If at anytime there is no left and right child and sum == 0 then we found the list and return res


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res = []
        if not root:
            return res
        stack = [(root, sum - root.val, [root.val])]
        while stack:
            node, sum, ls = stack.pop()
            if node:
                if node.left:
                    stack.append(
                        (node.left, sum - node.left.val, ls + [node.left.val]))
                if node.right:
                    stack.append((node.right, sum - node.right.val,
                                  ls + [node.right.val]))
            if node.left == None and node.right == None and sum == 0:
                res.append(ls)
        return res
