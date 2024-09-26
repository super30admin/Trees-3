'''
Iterative:
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation : Create a stack and append the elements in the stack while keeping track of the running sum , once we reach the leaf
node check if its equal to target, if yes add the stack trace to the global variable which is a matrix. Once done pop the last
element from the list.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.matrix = []

    def helper(self, root: TreeNode, sum1: int, rsum: int, l: list):
        if root == None:
            return

        if root.left == None and root.right == None:
            if (rsum + root.val) == sum1:
                l.append(root.val)
                self.matrix.append(list(l))

                # remove element as we have to go back
                l.pop()

        if root.left != None:
            l.append(root.val)
            self.helper(root.left, sum1, rsum + root.val, l)
            l.pop()

        if root.right != None:
            l.append(root.val)
            self.helper(root.right, sum1, rsum + root.val, l)
            l.pop()

    def pathSum(self, root: TreeNode, sum1: int) -> List[List[int]]:
        self.helper(root, sum1, 0, [])
        return self.matrix