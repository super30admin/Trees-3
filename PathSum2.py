'''
    Time Complexity:
        O(n) (where n = number of nodes)

    Space Complexity:
        O(h) (where h = height of the trees)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        PreOrder Traversal.
'''
class Solution:
    def __init__(self):
        self.sum = 0
        self.combos = []

    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        self.sum = sum
        self.generate_combos(root, 0, [])
        return self.combos

    def generate_combos(self, root, curr_sum, curr_combo):
        if root is None:
            return

        curr_sum = curr_sum + root.val
        curr_combo.append(root.val)

        if root.left is None and root.right is None and curr_sum == self.sum:
            self.combos.append(copy.deepcopy(curr_combo))
        else:
            self.generate_combos(root.left, curr_sum, curr_combo)
            self.generate_combos(root.right, curr_sum, curr_combo)

        curr_combo.pop()
