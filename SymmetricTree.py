#Recursive Solution:

def isSymmetric(self, root: TreeNode) -> bool:
    
    
    def helper(A, B):
        if not A and not B:
            return True
        if not A or not B:
            return False
        if A.val == B.val:
            return helper(A.left, B.right) and helper(A.right, B.left)
    return helper(root, root)


#Time : O(n)
#Space : O(n)