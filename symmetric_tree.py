// Time Complexity : O(n)
// Space Complexity : o(2h) h - height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
In this problem to find if the tree is  symmetric or not, we have to check the node value of left node is equal to the value of the right node.If yes we continue the loop else we return False indicating that the tree is not symmetric.


Recursive solution:

class Solution(object):
    def symmetric(self,p,q):
        if p==None and q==None:
            return True
        if (p==None) or (q==None):
            return(False)
        if p.val==q.val and self.symmetric(p.left,q.right) and self.symmetric(p.right,q.left):
            return(True)
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return(self.symmetric(root,root))
******************************************************************************************************
Iterative solution :

// Time Complexity :O(n)
// Space Complexity : O(2h) h-height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this iterative solution first we store the left and right pointers in an array.we then pop two pointers at once and then again go by depth first traversal till we rech the end.If we observe that the values at each stage is the same then we return True else we return as false.

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root==None:
            return True
        stack=[]
        stack.append(root.left)
        stack.append(root.right)
        while len(stack)!=0:
            root_right=stack.pop()
            root_left=stack.pop()
            if root_left==None and root_right==None:
                continue
            if root_left==None or root_right==None or root_left.val!=root_right.val:
                return False
            stack.append(root_left.left)
            stack.append(root_right.right)
            stack.append(root_left.right)
            stack.append(root_right.left)
        return True