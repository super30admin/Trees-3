
"""
101. Symmetric Tree
Easy
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
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
    Accepted
    Time Complexity: O(n)
    Space Complexity: O(h)
    
    Explanation: 
    
    # Example Usage
    # Creating a symmetric binary tree
    #       1
    #      / \
    #     2   2
    #    / \ / \
    #   3  4 4  3
    
    This will be symmetric if the left subtree is a mirror of the right subtree.
    So, we compare the right and left values and then, for the children we compare the opposite children.
    In this example, we compare 2 and 2 and then, 3 and 3 and 4 and 4.
    basically, L.left == R.right and L.right == R.left
    """
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None: return True
        def dfs(left, right): #base cases
            if not left and not right:
                return True
            if not left or not right:
                return False
            
            if left.val != right.val: # compare the nodes itself first
                return False
            return (
                dfs(left.left, right.right) and # compare the opposite children
                dfs(left.right, right.left)
            )
        return dfs(root.left, root.right)
        
    
    """
    Accepted
    Space Complexity: O(n)
    Time Complexity: O(n)
    
    Explanation: THe intuition is that we use the traversaks to generate two lists and compare
        The Two traversals are: innorde -> left, root, right and inorder -> right, root, left
        The catche here is that we need to add a null value to the list when we encounter a null node.
        Because we are trying to serialize the tree and null positions matter when comparing the symmetry.
        For ex:
        
          1
         / \
        2   2
       / \ / \
      3  4 4  3
        
        output lists
        [-101, 4, -101, -101, 2, -101, 3, -101, -101]
        [-101, 4, -101, -101, 2, -101, 3, -101, -101]
        -101 is the representation of null
        If the two lists are equal, then the tree is symmetric.
    """
    def isSymmetric2(self, root: Optional[TreeNode]) -> bool:
        lis = []
        lis2 = []
        def inorder(root):
            nonlocal lis
            if root is None:
                return None
            l = inorder(root.left)
            if l is None:
                lis.append(-101)
            lis.append(root.val)
            r = inorder(root.right)
            if r is None:
                lis.append(-101)
        def inorder2(root):
            nonlocal lis2
            if root is None:
                return None
            r = inorder2(root.right)
            if r is None:
                lis2.append(-101)
            lis2.append(root.val)
            l = inorder2(root.left)
            if l is None:
                lis2.append(-101)
        
        inorder2(root.left)
        inorder(root.right)
        return lis == lis2

LeetCode(PROBLEM, Solution).check()
