# // Time Complexity : O(n)
# // Space Complexity : 0(n) 
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root.left and not root.right:
            return True
        def helper(root1,root2):
            if root1!=None and root2!=None:
                if root1.val==root2.val:
                    return helper(root1.left,root2.right) and helper(root1.right,root2.left)
                else:
                    return False
            if root1==None and root2==None:
                return True
            return False
        return helper(root.left,root.right)