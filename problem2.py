# Approch used - BFS
#  time complexity is O(n) where n is the number of elements 
# Space complexity  O(h) where h is the height of the tre 
class Solution:
    def isSymmetric(self, root):
        if root is None:
            return True  # An empty tree is symmetric

        q = [root.left, root.right]

        while q:
            left_node = q.pop(0)
            right_node = q.pop(0)

            if left_node is None and right_node is None:
                continue
            if left_node is None or right_node is None:
                return False
            if left_node.val != right_node.val:
                return False

            # Check the symmetry of the leaves
            q.extend([left_node.left, right_node.right, left_node.right, right_node.left])

        return True