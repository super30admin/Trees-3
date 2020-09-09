
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 

#Recursive
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def checkSymmetric(root1, root2):
            if root1 is None or root2 is None:
                return root1 == root2
            
            if root1.val != root2.val:
                return False
            
            return checkSymmetric(root1.left, root2.right) and checkSymmetric(root2.left, root1.right)
        
        if root is None:
            return True
        return checkSymmetric(root.left, root.right)

#Iterative
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        queue = [root,root]
        
        while queue:
            root1 = queue.pop(0)
            root2 = queue.pop(0)
            
            if root1 is None and root2 is None:
                continue
            if root1 is None or root2 is None:
                return root1 == root2
            if root1.val != root2.val:
                return False
            
            queue.append(root1.left)
            queue.append(root2.right)
            queue.append(root2.left)
            queue.append(root1.right)
        return True
        
