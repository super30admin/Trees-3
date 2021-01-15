# Approach : recursively check outer and inner tree and if they are symmetric
# Return a boolean 
# Base case - If we are given empty tree, return True as it is symmetric
# Time : O(N) visiting all nodes once
# Space: O(N) calls recursively made

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:

        # Base case, when empty tree is given -- which is symmetric to itself
        if root == None:
            return True

        return self.isSymmetricHelper(root.left, root.right)


    def isSymmetricHelper(self, left, right):

        if left == None and right == None:
            return True

        if left == None or right = None:
            return left == right

        if left.val != right.val:
            return False

        
        return self.isSymmetricHelper(left.left, right.right) and 
        self.isSymmetricHelper(left.right, right.left)


# Approach: Iterative solution

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:

        if root == None:
            return True

        stack = []

        stack.append(root.left)
        stack.append(root.right)

        while stack != []:
            
            root.right = stack.pop()
            root.left = stack.pop()

            if root.left == None and root.right == None:
                return True

            if root.left == None or root.right == None:
                return root.left == root.right

            if root.left.val != root.right.val:
                return False

            
            stack.append(root.left.left)
            stack.append(root.right.right)
            stack.append(root.left.right)
            stack.append(root.right.left)

        return True