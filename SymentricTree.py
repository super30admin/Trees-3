"""
The approach here is to start from the root node and keep comparing the sub-trees, at every stage we
are comparing the symentric patners both subtrees. if there is case such that one node exsists and
the other does'nt then we return false.

Time complexity - O(N)
Space Complexity - O(N)
"""

def isSymmetric(self, root):
        if root is None:
            return True
        else:
            return self.Helper(root.left,root.right)
        
            
            
def Helper(self,left,right):
        
    if left is None and right is None:
        return True
        
    if left is not None and right is not None:
            
        if left.val != right.val:
            return False
    else:
        return False
        
        
    return self.Helper(left.left,right.right) and self.Helper(left.right,right.left)