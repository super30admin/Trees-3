# Time Complexity :O(n) where n is number of nodes
# Space Complexity :O(d) - Depth
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 113

# Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
#
# A leaf is a node with no children.
#
# Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
# Output: [[5,4,11,2],[5,8,4,5]]
#
# Input: root = [1,2,3], targetSum = 5
# Output: []
#
# Input: root = [1,2], targetSum = 0
# Output: []

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    # Having a global result array
    def __init__(self):
        self.res = []

    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """

        # Recursive function
        def recurr(root, targetSum, currSum, path):
            # Base case.
            if not root:
                return

            # Adding each element to currSum
            currSum += root.val
            # Add value to the path
            path.append(root.val)

            # Reaching the leaf node. At that time check for the sum == targetSum condition.
            if root.left is None and root.right is None:
                if currSum == targetSum:
                    # Append as a new list because path is passed as a reference.
                    self.res.append(list(path))
                # Once processed, if it's equal or not, we need to pop that from list so that the parent gets a chance.
                path.pop(-1)
                # And we return from here.
                return

            # Recurssing on left and right
            recurr(root.left, targetSum, currSum, path)
            recurr(root.right, targetSum, currSum, path)

            # Make sure you remove the element as well after processing.
            path.pop(-1)

        path = []
        # Current Sum would be 0 at start.
        recurr(root, targetSum, 0, path)
        return self.res

root = TreeNode(5)
root.left = TreeNode(4)
root.left.left = TreeNode(11)
root.left.left.left = TreeNode(7)
root.left.left.right = TreeNode(2)

root.right = TreeNode(8)
root.right.left = TreeNode(13)
root.right.right = TreeNode(4)
root.right.right.left = TreeNode(5)
root.right.right.right = TreeNode(1)

print(Solution().pathSum(root,22))