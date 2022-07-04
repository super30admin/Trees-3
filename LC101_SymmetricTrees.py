"""
Leetcode 101 -  Symmetric Trees - BFS using queue
Method - recursively check at every node if it is symmetric around its center
TC- O(N), SC - O(h) - where h is the height of the tree
Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false


"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
Recursive void - 
The idea here is to look at the two subtrees left and right at the same time to check if they are symmetric i.e. one's left has to be equal to other's right.

"""
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) :
        if root is None:
            return True
        self.isSymmetric =True
        self.helper(root.left, root.right)
        return self.isSymmetric
    def helper(self, node1, node2):
        if node1 is None and node2 is None:
            return 
        if node1 is None or node2 is None:
            self.isSymmetric=False
            return
        if node1.val!=node2.val:
            self.isSymmetric = False
            
        self.helper(node1.left, node2.right)
        self.helper(node1.right, node2.left)
        


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
Recursive Boolean - The idea is same as void recursive but here you have to make sure all cases cover a return True/False.
To return the valid case we can add our valid boolean comparison in front with the recursive calls.
"""
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        isSymmetric = True
        if root == None:
            return True
        return self.helper( root.left, root.right) 
    def helper (self, node1, node2):
        if node1 is None and node2 is None:
            return True
        if node1 is None or node2 is None or node1.val!=node2.val:
            return False
        return node1.val == node2.val and self.helper(node1.left, node2.right) and self.helper(node1.right, node2.left)
    