#-------------Solution 1 : Void based recursion, using global variable flag-----
''' Time Complexity : O(n)
    Space Complexity : O(h) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : Key idea : Left.left should be equal to right.right

'''
class Solution:
    def __init__(self):
        self.flag = True

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        def helper(left, right):
            if left is None and right is None:
                return
            if  left and right is None:
                self.flag = False
                return
            if  left is None and right:
                self.flag = False
                return
            if left.val != right.val:
                self.flag = False
                return
            
            helper(left.left,right.right)
            helper(left.right,right.left)
        
        helper(root.left,root.right)
        return self.flag


#-------------Solution 2 : Boolean based recursion-----
''' Time Complexity : O(n)
    Space Complexity : O(h) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : Key idea : Left.left should be equal to right.right

'''
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        def helper(left, right):
            if left is None and right is None:
                return True
            if  left and right is None:
                return False
            if  left is None and right:
                return False
            if left.val != right.val:
                return False
            
            return (helper(left.left,right.right) and helper(left.right,right.left))
        
        return helper(root.left,root.right)