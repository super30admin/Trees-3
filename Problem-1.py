"""
Approach-1: Use a new path copy for every recursive call
TC: O(n)
SC: O(n^2)
"""
class Solution:
def __init__(self):
    self.out = []
    self.targetSum = 0


def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
    self.targetSum = targetSum
    if not root: return self.out
    self.helper(root, 0, [])
    return self.out


def helper(self, root, localsum, curr):
    if not root:
        return
    localsum = localsum + root.val
    curr.append(root.val)
    self.helper(root.left, localsum, copy.copy(curr))
    if not root.left and not root.right:
        if localsum == self.targetSum:
            print(curr)
            self.out.append(curr)
    self.helper(root.right, localsum, copy.copy(curr))

"""
Approach-2: Use a new path copy for storing the result only. Then backtrack.
TC: O(n)
SC: O(n)
"""

class Solution:
    def __init__(self):
        self.out = []

    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        self.targetSum = targetSum
        self.helper(root, targetSum, [])
        return self.out

    def helper(self, root, targetSum, curr):
        if not root:
            return

        targetSum -= root.val
        curr.append(root.val)
        self.helper(root.left, targetSum, curr)
        if not root.left and not root.right:
            if targetSum == 0:
                self.out.append(copy.copy(curr))
        self.helper(root.right, targetSum, curr)
        curr.pop()