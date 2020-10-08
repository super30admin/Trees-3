"""
Problem: 113. Path Sum II
Solution:
Time Complexity: O(n^2), iterate all the nodes and copy root-to-leaf paths to the output list
Space Complexity: O(n) considering the space taken by output, O(1) if we don't consider the space taken by output
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # class variable for output
    output = []

    def pathSum(self, root, sum):
        self.helper(root, sum, 0, [])
        return self.output

    def helper(self, node, target, curr_sum, curr_path):
        # Base case
        if node is None:
            return

        # For both leaf and non-leaf nodes
        curr_path.append(node.val)
        curr_sum += node.val

        # Add the output, only if its a lead node
        if node.left is None and node.right is None and target == curr_sum:
            # if you directly append curr_path, you'll get empty list
            # self.output.append(curr_path)
            self.output.append(list(curr_path))
        else:
            # iterate left and right subtree
            self.helper(node.left, target, curr_sum, curr_path)
            self.helper(node.right, target, curr_sum, curr_path)

        # After reaching leaf node, remove the last element
        curr_path.remove(curr_path[-1])