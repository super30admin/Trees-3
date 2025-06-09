# // Time Complexity :O(n)
# // Space Complexity :O(h), O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# Every recursive problem can also be solved wiht recusive methods mainly for trees, in resursive we split into smaller parts and check which should be equal to which
# In interative we use QUEUE we ad in four values and check them , 
# we need to eval 4 conditions before making calls


##Iterative

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q = deque()
        if root.left is None and root.right is None:return True
        q.append(root.left)
        q.append(root.right)
        while(len(q) >1):
            lnode=q.popleft()
            rnode=q.popleft()
            
            if lnode is None and rnode is None:
                pass
            elif (lnode is None and rnode is not None) or (lnode is not  None and rnode is  None) : return False
            elif lnode.val!=rnode.val:return False
            else:
                q.append(lnode.left)
                q.append(rnode.right)
                q.append(lnode.right)
                q.append(rnode.left)
        print(q)
        if len(q):return False
        return True
###########################################################################
#Recursive
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        def  helper(l, r):

            if  l is None and r is None :return True
            if l is  None and r is not  None :return False
            if l is not  None and r is   None :return False
          
            # print(l.val,r.val)
            # if not root.right and not root.left
            if l.val!=r.val:return False
            if helper(l.left,r.right) and helper(l.right, r.left):
                return True
            
            return False
        return helper(root.left,root.right)
        
