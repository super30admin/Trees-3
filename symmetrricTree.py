# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

# To check whether a tree is symmetric or not, I check the left node of left subtree and right node of right sbutree with right node of left subtree to left node of right subtree
# Time complexity: O(H)
# Space Complexity: O(1)
class Solution:
    def __init__(self):
        self.paths = list()
    def isSymmetric(self,root):
        if root is None:
            return True
        return self.helper(root.leeft,root.right)

    def helper(self,left,right):
        if (left is None or right is None):
            return True
        if(left is None or right is None or left.val != right.val):
            return False
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)

n1 = TreeNode(1)
n2 = TreeNode(2)
n3 = TreeNode(2)
n4 = TreeNode(3)
n5 = TreeNode(4)
n6 = TreeNode(4)
n7 = TreeNode(3)

n1.left = n2
n1.right = n3
n2.left = n4
n3.left = n5
n3.right = n6


s = Solution()
s = s.pathSum(n1,22)
print(s)