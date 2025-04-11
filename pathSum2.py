import copy
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Time Complexity: O(n*h) where n is the number of nodes in the tree, and h is the maximum height of the tree
# Space Complexity: O(n*h)

# Approach:
# We want to add the element at each node to a list, while also updating the sum by adding the element to the current sum.
# So when we reach a leaf node, we will have to check if the sum is same as targetSum, if it is, we add the list constructed so far to the result.
# Since a list will always be passed as a reference to a recursive call and the new elements will be added to the referene, we will need to pass a copy of the list to each node.
# We then mutate the copy we received in the parent, and check for leaf node and current sum.
# This way, when a function call gets popped from the recursive stack, the origina

class Solution:
    def pathSum(self, root, targetSum: int):
        # Initializing resultant list
        self.res = []
        self.helper(root, 0, [], targetSum)
        return self.res

    # Recursive function to build the result
    def helper(self, node, currSum, arr, targetSum):
        # base case
        if not node:
            return

        # At each node, we update the current sum by adding the value at the current node to the current sum
        currSum += node.val
        # We also maintain a local array to keep track of the path
        arr.append(node.val)
        # If we reach a leaf node, we want to check what the current sum is at this point
        if not node.left and not node.right:
            # If the current sum is the same as targetSum, we want to append the path built so far to the result
            if currSum == targetSum:
                self.res.append(arr)

        # Since we do not want to update the same reference of the local array for each call, we pass a copy of the array to left and right calls.

        self.helper(node.left, currSum, copy.copy(arr), targetSum)
        self.helper(node.right, currSum, copy.copy(arr), targetSum)


# Time Complexity: O(n) where n is the number of nodes in the tree
# Space Complexity: O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Backtracking
# Before travelling to the right sub-tree, we want to remove the left sub-tree from the local list.
# This will be a more optimal solution as we will maintain a single list throughout recursion instead of creating copy for each recursive call.
# Whenever the target sum is met and we're at a leaf node, we will add a copy of the local list at that point of time to the result.
class Solution:
    def pathSum(self, root, targetSum: int):
        def helper(node, currSum, arr):
            if not node:
                return

            currSum += node.val
            arr.append(node.val)
            if not node.left and not node.right:
                if currSum == targetSum:
                    res.append(arr.copy())

            helper(node.left, currSum, arr)
            helper(node.right, currSum, arr)
            # Popping the last element from the local array when we are done traversing it.
            arr.pop()

        res = []
        helper(root, 0, [])
        return res