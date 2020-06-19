class Solution(object):
    # this init is used by both methods.
    def __init__(self):
        self.result = []
        self.target = 0

    # Time Complexity : O(n), where n is the number of nodes in the tree.
    # Space Complexity : O(n^2), because of a copy of path for every node was created.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # For every node in the tree keep track of the total sum and the path, for every
    # leaf compare the total to the given sum and add the path to a global result.
    # FOr every node a new copy of the path is passed, resulting in O(n^2) space.
    def pathSum(self, root, sum):
        if not root:
            return []
        self.target = sum
        self.helper(root, 0, [])
        return self.result

    def helper(self, root, currSum, path):
        if root == None:
            return

        currSum += root.val
        path.append(root.val)
        if root.left == None and root.right == None and currSum == self.target:
            self.result.append(path)

        self.helper(root.left, currSum, list(path))
        self.helper(root.right, currSum, list(path))

#------------------------------------------------------x---------------------------------------------------------------#

    # Time Complexity : O(n), where n is the number of nodes in the tree.
    # Space Complexity : O(h), where h is the max height of the tree.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # For every node in the tree keep track of the total sum and the path, for every leaf
    # compare the total to the given sum and add a copy of the path to a global result.
    # The same array is reused by popping the last added value to the path,
    # a copy is only made if path totaling to the given sum is encountered.
    def pathSumBacktrack(self, root, sum):
        if not root:
            return []
        self.target = sum
        self.backtrack(root, 0, [])
        return self.result

    def backtrack(self, root, currSum, path):
        if root == None:
            return
        # action
        currSum += root.val
        path.append(root.val)
        if root.left == None and root.right == None and currSum == self.target:
            self.result.append(list(path))
        # recurse
        self.backtrack(root.left, currSum, path)
        self.backtrack(root.right, currSum, path)
        # backtrack
        path.pop()
