''' 
Problem: https://leetcode.com/problems/symmetric-tree/ 

Approach:
1. Use a recursive function to compare the left and right subtrees.
2. Check if both nodes are None, which means they are symmetric at that level.
3. If one node is None and the other is not, they are not symmetric.
4. If both nodes are present, check if their values are equal.
5. Recursively check the left child of the left node with the right child of the right node and vice versa.
6. Return True if both recursive calls return True, otherwise return False.
7. The main function starts the recursion with the left and right children of the root.

Time Complexity: O(N) where N is the number of nodes in the tree. 
Space Complexity: O(H) where H is the height of the tree due to recursion stack.
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def solve(leftnode, rightnode):
            if not leftnode and not rightnode:
                return True

            if (not leftnode and rightnode) or (not rightnode and leftnode):
                return False

            if leftnode.val != rightnode.val:
                return False

            return solve(leftnode.left, rightnode.right) and solve(
                leftnode.right, rightnode.left
            )

        return solve(root.left, root.right)
