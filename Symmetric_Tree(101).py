# Time Complexity: O(N)
# Space Complexity: O(N) for the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    # BFS Solution
    # we check whether the tree is a mirror image from the middle
    # i.e left.left==right.right and left.right=right.left
    # we append the elements in the queue in the same manner and pop 2 elements at a time and compare them
        def isSymmetric(self, root: Optional[TreeNode]) -> bool:
            if root==None or (root.left==None and root.right==None):
                return True

            queue = list()
            queue.append(root.left)
            queue.append(root.right)

            while len(queue)!=0:
                left = queue.pop(0)
                right = queue.pop(0)

                if left==None and right==None:
                    continue
                if left==None or right==None or left.val!=right.val:
                    return False

                queue.append(left.left)
                queue.append(right.right)
                queue.append(left.right)
                queue.append(right.left)

            return True


    # Recursive Solution
#     def __init__(self):
#         self.isValid = True

#     def isSymmetric(self, root: Optional[TreeNode]) -> bool:
#         if root==None or (root.left==None and root.right==None):
#             return True
#         self.dfsCheck(root.left,root.right)
#         return self.isValid

#     def dfsCheck(self,left,right):
#         if left==None and right==None:
#             return
#         if left==None or right==None or left.val!=right.val:
#             self.isValid = False
#             return

#         if self.isValid is False:
#             return
#         self.dfsCheck(left.left,right.right)
#         if self.isValid is False:
#             return
#         self.dfsCheck(left.right,right.left)