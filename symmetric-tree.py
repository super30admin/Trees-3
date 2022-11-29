#TC: O(n)
#SC: O(height of the tree)
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def isSymmetricHelper(root1,root2):
            if not root1 or not root2: return (not root1 and not root2)
            
            return (root1.val==root2.val
                        and isSymmetricHelper(root1.left,root2.right)
                            and isSymmetricHelper(root1.right,root2.left))

        return isSymmetricHelper(root.left,root.right)