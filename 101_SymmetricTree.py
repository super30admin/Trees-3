"""
TODO- Try iterative solution - uses BFS using queue
Leetcode- https://leetcode.com/problems/symmetric-tree/ (submitted)
TC- O(N), SC - O(1)
Lecture- NA

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100

Follow up: Could you solve it both recursively and iteratively?
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    """
    Ideation- recursive (void function)
    The idea here is to look at the two subtrees left and right at the same time to check if they are symmetric.
    Now, because they are symmetric, one's left has to be equal to other's right.
    """
    def isSymmetric1(self, root):
        if root is None:
            return True
        self.isSymmetric = True
        self.helper(root.left, root.right)
        return self.isSymmetric

    def helper2(self, root1, root2):
        if root1 is None and root2 is None:
            return
        if root1 is None or root2 is None:
            self.isSymmetric = False
            return
        if root1.val != root2.val:
            self.isSymmetric = False

        self.helper(root1.left, root2.right)
        self.helper(root1.right, root2.left)

    """
    Ideation - recursive (boolean)
    The idea is same as void recursive but here you have to make sure all cases cover a return True/False. To return
    the valid case we can add our valid boolean comparison in front with the recursive calls.
    """
    def isSymmetric(self, root):
        if root is None:
            return True
        return self.helper(root.left, root.right)

    def helper(self, root1, root2):
        if root1 is None and root2 is None:
            return True
        if root1 is None or root2 is None or root1.val != root2.val:
            return False
        #  to return valid case as boolean we can put 'root1.val == root2.val'
        return root1.val == root2.val and self.helper(root1.left, root2.right) and self.helper(root1.right, root2.left)
