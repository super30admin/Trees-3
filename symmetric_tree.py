# Time Complexity: O(n)
# Space Complexity: O(h)


class Solution:
    def isSymmetric(self, root):
        def isSymmetricHelper(node1, node2):
            if not node1 and not node2:
                return True
            if not node1 or not node2:
                return False
            return (node1.val == node2.val and
                    isSymmetricHelper(node1.left, node2.right) and
                    isSymmetricHelper(node1.right, node2.left))

        return isSymmetricHelper(root, root)
