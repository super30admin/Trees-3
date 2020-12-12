# Iterative Solution
# Time: O(N)
# Space: O(N)
#
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root: return True

        nodes = [(root.left, root.right)]
        i = 0

        while i < len(nodes):
            t1, t2 = nodes[i]

            if (t1 and not t2) or (not t1 and t2): return False
            if t1:
                if t1.val != t2.val: return False

                nodes.append((t1.right, t2.left))
                nodes.append((t1.left, t2.right))
            i += 1

        return True
