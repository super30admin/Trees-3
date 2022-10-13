#Time Complexity: O(n)
#Space Complexity: O(n)
#Did it run on Leetcode: Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        leftSide = collections.deque([root.left]) # bfs queue for the left side
        rightSide = collections.deque([root.right]) # bfs queue for the right side
        while leftSide and rightSide: # while both exist
            left = leftSide.popleft() # node on the left side
            right = rightSide.popleft() # node on the right side
            if left and right: # if both nodes exist
                if not left.val == right.val: # make sure they have the same value
                    return False
                # append the nodes in the next level in the opposite order to check for symmetry
                leftSide.append(left.left) 
                leftSide.append(left.right)
                rightSide.append(right.right)
                rightSide.append(right.left)
            elif left or right: # if only one side has a node, it is not symmetric
                return False
        return not leftSide and not rightSide # make sure neither side has any nodes remaining
        