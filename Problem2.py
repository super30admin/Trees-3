#Time complexity: O(n)
#Space complexity: O(n)

#Accepted on Leetcode

#Approach
#Using BFS traverse the tree as a queue, keep the mirror image nodes next to each other in pairs
#Start with left and right of the root, pop them in pairs, for each pair push (left.left, right.right) and (left.right, right.left) in this order
#This will ensure that mirror images are always next to each other in the queue as pairs , if any pair does not match, tree is not symmetric


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


from collections import deque
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root.left == None and root.right == None:
            return True
        queue = deque([root.left, root.right])

        while len(queue):
            left = queue.popleft()
            right = queue.popleft()

            if left == None and right == None:
                continue
            if left == None or right == None or left.val != right.val:
                return False

            queue.append(left.left)
            queue.append(right.right)
            
            queue.append(left.right)
            queue.append(right.left)
            
        return True
            


    