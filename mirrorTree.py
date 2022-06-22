"""Approach:

Start helper call with two root values, exactly same root. Then 
if either t1 or t2 is None return False => As tree is unbalanced
if both t1 and t2 are none then return true => as both nodes are pointing to None, both just passed the leaf nodes and reached end of that path.

TC : O(n). Because we traverse the entire input tree once,where n is the total number of nodes in the tree.

SC : O(n)  # recursive calls is bound by the height of the tree. For worst case, the tree is skewed in one side and the height is in O(n). Hence stack space used is O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.isMirror(root.left, root.right)

    def isMirror(self, t1, t2) -> bool:
        # check if both are None
        if t1 is None and t2 is None: return True   # if both are none, then tree is symmetric
        # else check if one of them is none
        if t1 is None or t2 is None: return False   # if one of them is none, then tree is not symmetric
        # else check both of the nodes have same value. and there left and right subtrees are mirror of one another as well
        return t1.val == t2.val and self.isMirror(t1.right, t2.left) and self.isMirror(t1.left,t2.right)



"""Approach: Use BFS

TC O(N) We process each node in the tree, till the end, in the worst case scenario to ensure tree is not asymmetric
SC O(N) at any point at maximum we have N/2 or less  nodes in the queue
"""
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root: return False
        q = deque()
        # check if both left and right nodes exist and add to the q
        if root.left and root.right:
            q.append(root.left)
            q.append(root.right)
        else:
            return False
        
        while q:
            # pop left and right from the q
            left = q.popleft()
            right = q.popleft()
            # if both are None, continue
            if left is None and right is None: continue
            # if either is None or the values don't match, return False
            if left is None or right is None or left.val != right.val: return False
            # else add left=left, right-right, left-right, right-left, so when they come out
            # of the queue, they come in such an order that their values are always same in a symmetric tree
            # if not, we return False
            q.append(left.left)
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)
        # if we made it here, then tree is valid
        return True

