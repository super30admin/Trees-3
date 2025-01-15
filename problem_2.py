# TC: O(n)
# SC: O(h) stack space ; height of tree

def isSymmetric(root):

    def helper(left, right):
        if not left and not right:
            return True
        
        if not left or not right:
            return False
        
        return left.val == right.val and helper(left.left, right.right) and helper(left.right, right.left)

    return helper(root.left, root.right)