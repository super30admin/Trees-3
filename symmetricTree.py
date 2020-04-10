"""
Recurive solution for symmetric binary tree
Time complexity: O(n)
Space complexity: O(1)
Challenges: Trying iterative solution now. Having a few errors.
Comments: Given below.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        # If there is no node, return True
        if not root:
            return True
            
        # Define a  recursive funtion with left and right nodes
        def recursive(l,r):
              # If both nodes are absent, return true as we have reached the  tip of both routes
              if not l and not r:
                  return True
              # If one of the nodes is absent, then it is obviously not symmetric
              if not l or not r or l.val != r.val:
                  return False
              # Check if values are same and nodes left of left node and right of right node are same (by recursively calling \
              the function), and right of left node and left of  right node are same (by recursively calling the function)
              return recursive(l.left, r.right) and recursiverec(l.right, r.left)  #l.val == r.val 
              
         # return the result using the function above
         return recursive(root.left, root.right)
