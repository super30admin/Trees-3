class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# Stack 
# TC : O(H) 
# SC : 2H ~ O(H)
class Solution1:
    def isSymmetric(self, root):
        if root ==None: return True
        stack = []
        # take in initial left and right in to the stack
        stack.append(root.left)
        stack.append(root.right)
        # while the stack is not empty pop previous right & left check if breaks then append each level nodes in to the stack. 
        while stack:
            right = TreeNode(stack.pop())
            left = TreeNode(stack.pop())
            if not left and not right:continue
            if left == None or right ==None or left.val != right.val: return False
            stack.append(left.left)
            stack.append(right.right)
            stack.append(left.right)
            stack.append(right.left)
        return True

# Recursion
# TC & SC = O(H)
# We traverse on the left and right simulatneously. Make checks for left and right values picked. When ever it breaks we return False or else True.
class Solution2:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None: return True
        # traverse left and right
        return self.helper(root.left, root.right)
    
    def helper(self, left, right):
        # base
        # When we reach leaf every time we return True to prev call
        if left == None and right == None: return True
        # breakage: either one has reached None before the other or values are unequal return False
        if left == None or right == None or left.val != right.val: return False
        # logic
        # return True if subtrees are symmetric
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)