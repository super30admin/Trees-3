# Pallavi Sapale
# yet to try Method 1 and 2

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Method 1 : Level Order Traversal :
# Time : O(n^2), because for every row( every level ) create a list and check if its a palindrome
# Space : O(n)

# Method 2 : Inorder Traversal :
# Time : O(n),
# Space : O(n)

# Method 3 : Two pointers ( Iterative )
# Time : O(n) traverse all nodes
# Space : O(2h) , bound to the height of tree -- same stack with two values at a time, instead of two stacks

# Method 4 : Two pointers ( Recursive)
# Time : O(n) traverse all nodes
# Space : O(h) , bound to the height of tree -- O(h)+O(h) space because two stack


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:

        # Method 4 : Recursive solution ( STack under the hood )
        '''
        - intuition comes from brute force approaches and inorder traversal, thinking of O(n) approach

        Problem :
        - do not call 1st with root,root, call with root.left, root.right
        - check the return here
        - order : 1 2 2 3 3 5 5 6 6 4 4 7 7 8 8
        '''

        '''
         if root == None: return True
        return self.recursive(root.left,root.right) # what if we call with root, root

    def recursive(self,left,right):

        if left == None and right == None: # if both left and right pointer hit None
            return True


        # check for either None, and values not match == return False right away
        if left == None or right == None or left.val!=right.val: return False 

        #return self.recursive(left.left,right.right)
        #print(left.left.val,right.right.val)

        #return self.recursive(left.right,right.left)

        return self.recursive(left.left,right.right) and self.recursive(left.right,right.left)
        # why "and" here


        '''

        # Method 3 : Two pointers ( Iterative )
        '''

        Problem :
        - remember the order of insertion, and popping order
        - insert left 1st , pop right 1st
        - for condition to check both None values, do not return True >> continue, we return True for the recursive approach, because that
        is returning true to function level call
        - order : 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8

        '''
        if root == None:
            return True
        stack = []  # stores tree nodes
        right = TreeNode()
        left = TreeNode()

        stack.append(root.left)
        stack.append(root.right)
        while len(stack) != 0:
            right = stack.pop()
            left = stack.pop()

            # after popping check conditions :
            # DO not miss this !
            if left == None and right == None: continue  # if both are one, do not go and check if null values match it will give error

            if left == None or right == None or left.val != right.val:  # same as recursive approach
                return False

            stack.append(left.left)
            stack.append(right.right)
            stack.append(left.right)
            stack.append(right.left)

        return True  # entire tree is traversed



