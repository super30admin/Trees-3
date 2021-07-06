"""
// Time Complexity : 0(n^2), traversing each node and copying the path at each valid leaf
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

--> start right and left children of root
--> go along comparing corresponding nodes

// Your code here along with comments explaining your approach

"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def compare(self, node1, node2):
        if not node1 and not node2: 
            return True
        
        if not node1 or not node2 or node1.val != node2.val: 
            return False
            
        return self.compare(node1.left, node2.right) and self.compare(node1.right, node2.left) #will return true only if both the paths are valid

    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        if root==None:
            return True
        
        return self.compare(root.left,root.right) #sending left and right children