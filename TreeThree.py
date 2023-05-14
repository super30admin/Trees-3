# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)
# Time Complexity : O(n)
# Space Complexity : O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    result = []
    def pathSum(self, root, sum):
        self.result = []
        if not root:
            return self.result
        self.helper(root, sum, 0, [])
        return self.result

    def helper(self, root, sum, currSum, path):
        # base
        if not root:
            return
        # logic
        currSum += root.val
        path.append(root.val)
        if not root.left and not root.right:
            if currSum == sum:
                self.result.append(path[:])
        self.helper(root.left, sum, currSum, path)
        self.helper(root.right, sum, currSum, path)
        path.pop()

## Problem2 (https://leetcode.com/problems/symmetric-tree/)
# Time Complexity : O(n)
# Space Complexity : O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def isSymmetric(self, root):
        if not root:
            return True
        return self.helper(root.left, root.right)

    def helper(self, left, right):
        # base
        if not left and not right:
            return True
        if not left or not right or left.val != right.val:
            return False
        # logic
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)
