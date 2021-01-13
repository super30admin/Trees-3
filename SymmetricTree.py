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
        Divide the subtrees of the root into two individual subtrees: t1 and t2.
        Check if t1's left is similar to t2's right, and
            t1's right is similar to t2's left, and
            t1's root val is equal to t2's root value
        Do this recurssively.
'''
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True

        return self.are_mirror(root.left, root.right)

    def are_mirror(self, t1, t2):
        if t1 is None and t2 is None:
            return True

        if t1 is None or t2 is None:
            return False

        if not self.are_mirror(t1.left, t2.right):
            return False

        if not self.are_mirror(t1.right, t2.left):
            return False

        return t1.val == t2.val
