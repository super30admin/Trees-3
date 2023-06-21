# Time Complexity :O(n)
# Space Complexity :O(h) - height of tree
# Leet Code: Yes

import queue
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def check(rootLeft, rootRight):
            if rootLeft is None and rootRight is None:
                return True
            if rootLeft is None or rootRight is None:
                return False

            
            if rootLeft.val == rootRight.val:
                return check(rootLeft.right, rootRight.left) and check(rootLeft.left, rootRight.right)
        
        return check(root.left, root.right)