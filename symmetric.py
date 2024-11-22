# The code defines an isSymmetric method to determine if a binary tree is symmetric around its center.
# A tree is symmetric if its left and right subtrees are mirror images of each other.

# Helper Function (is_mirror):
#   - The is_mirror function is a recursive helper that checks if two nodes (n1 and n2) are mirror images of each other.
#   - Base Cases:
#       - If both nodes (n1 and n2) are None, return True as two empty subtrees are symmetric.
#       - If only one of the nodes is None, return False as one empty and one non-empty subtree cannot be symmetric.
#   - Recursive Case:
#       - Check if the values of the two nodes are equal (n1.val == n2.val).
#       - Recursively check:
#           - Whether the left child of n1 is a mirror of the right child of n2 (is_mirror(n1.left, n2.right)).
#           - Whether the right child of n1 is a mirror of the left child of n2 (is_mirror(n1.right, n2.left)).
#       - Return True only if all the above conditions are satisfied.

# Main Execution:
#   - The isSymmetric method starts by calling is_mirror on the root's left and right children.
#   - If the two subtrees are mirror images, the tree is symmetric, and the method returns True; otherwise, it returns False.

# TC: O(n) - Each node in the tree is visited once, making the time complexity linear with the number of nodes.
# SC: O(h) - The space complexity is proportional to the height of the tree due to the recursion stack.


from typing import Optional


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def is_mirror(n1, n2): # n1:left, n2:right
            if not n1 and not n2:
                return True
            
            if not n1 or not n2:
                return False
            
            return n1.val == n2.val and is_mirror(n1.left, n2.right) and is_mirror(n1.right, n2.left)
        
        return is_mirror(root.left, root.right)