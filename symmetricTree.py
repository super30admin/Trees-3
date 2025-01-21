class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def isMirror(l, r):
            # Base Case
            if not l and not r:  # Both nodes are null
                return True
            if not l or not r:  # Only one node is null
                return False
            # Check if current nodes are equal and their subtrees are mirrors
            # Recursive Case
            return (
                l.val == r.val
                and isMirror(l.left, r.right)
                and isMirror(l.right, r.left)
            )

        return isMirror(root.left, root.right)
        # T: O(n), S: O(h)
