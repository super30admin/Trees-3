
#time Complexity: O(n)
#Space Complexity: O(1)
#leetcode submission: successful
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        def helper(node1,node2):
            if node1 is None and node2 is None:
                return True
            if node1 is not None and node2 is not None:
                if node1.val == node2.val:
                    return (helper(node1.right,node2.left) and helper(node2.right,node1.left))
            return False
        return helper(root,root)