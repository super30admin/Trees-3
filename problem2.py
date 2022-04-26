#Symmetric tree
# // Time Complexity : O(N)
# // Space Complexity :O(h) h=height of the tree
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : no


def isSymmetric( root):
    if root==None: return True
    return helper(root.left, root.right)
    
def helper(left, right):
    if (right==None and left==None): return True
    if(right and  left and  right.val==left.val):
        return helper(left.left, right.right) and helper(left.right, right.left)
    else:
        return False