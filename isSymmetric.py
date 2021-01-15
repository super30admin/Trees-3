# Time Complexity : O(N) - since we traverse entire input tree and the total run time is O(N)
# Space Complexity : O(H) - Recursive call be will made till the height of the tree and in worst case if the tree is linear then it's O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        # Base case        
        if root == None:
            return True
        # send root.left and root.right to the helper function
        return self.helper(root.left, root.right)
   
    def helper(self,rootleft, rootright):
        # go till leaf node and check rootleft is equal to rootright    
        if not rootleft or not rootright:
            return rootleft == rootright
        
        # recursive call to check each node
        return rootleft.val == rootright.val and self.helper(rootleft.left, rootright.right) and self.helper(rootright.left, rootleft.right)
