# Time Complexity :
# O(N)

# Space Complexity :  
# O(H)  ,  H = height of tree, recursion creates a stack where all nodes upto the left most child will be stored at max. 


# Approach:
# ===> DFS approach.


class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        
        return self.checkSymmetric(root.left, root.right)

    def checkSymmetric(self, rootLeft, rootRight):

        # check if both left and right child are null, then that node itself is "symmetric"
        if not rootLeft and not rootRight:
            return True
        
        #check if one of left or right child node is null, in that case the node is "not symmetric"
        if not rootLeft or not rootRight:
            return False
        
        # recursive calls by checking the leftNode's val and rightNode's val and passing their child nodes in function
        return rootLeft.val==rootRight.val and self.checkSymmetric(rootLeft.left, rootRight.right) and self.checkSymmetric(rootLeft.right, rootRight.left)