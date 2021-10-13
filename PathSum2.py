# Time complexity: O(n^2) where n is the number of nodes in the tree
# Space complexity: O(n)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def pathSum(self, root, targetSum):
        if not root:
            return []
        result = []
        self.helper(root, targetSum, [], result)
        return result

    def helper(self, root, targetSum, temp, result):
        if not root:
            return
        targetSum -= root.val
        temp.append(root.val)
        if not root.left and not root.right and targetSum == 0:
            result.append(list(temp))

        self.helper(root.left, targetSum, temp, result)
        self.helper(root.right, targetSum, temp, result)
        temp.pop()
        targetSum += root.val
