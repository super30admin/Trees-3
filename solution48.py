#Time Complexity:O(n)
#Space Complexity:O(1)

#Recursive approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:                                           
        if root is None:
            return True                                                                     #if tree is empty return true
        return self.helper(root.left,root.right)                                            #recursive function call
        
    def helper(self, left:TreeNode, right:TreeNode)->None:
        if left is None and right is None:                                                  #if the leaf node is reached on both sides of tree 
            return True                                                                     #return True
        if left is None or right is None or (left.val!=right.val):                          #if just one of the subtrees reached leaf node or the two sides of subtree values dont match
            return False                                                                    #return False
        return self.helper(left.left,right.right) and self.helper(left.right,right.left)    #recursive funtion call for remaining parts of the tree check

#Iterative approach
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:                                          
        if root is None:                                                                    #if tree is empty return true
            return True
        s=[]                                                                                #declare a stack
        s.append(root.left)                                                                 #append the left node to stack
        s.append(root.right)                                                                #append the right node to stack
        while(s):                                                                           # while the stack is not empty
            right=s.pop()                                                                   #pop the root element of both subtrees
            left=s.pop()
            if left is None and right is None:                                              #if leaf node is reached continue
                continue
            if left is None or right is None or left.val!=right.val:                        # if just one side reached leaf node or if the values dont match
                return False                                                                #return False
            s.append(left.left)                                                             #append the rest of the nodes to the stack
            s.append(right.right)
            s.append(left.right)
            s.append(right.left)
        return True                                                                         #return true if whole tree was parsed