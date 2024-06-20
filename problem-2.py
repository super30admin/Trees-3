# depth first search
# Time Complexity : O(n)
# space complexity : O(h)

# Approach :

# use dfs
# keep a boolean flag which keeps a track of the tree.
# we compare the following values
# left tree left child and right tree right child
# left tree right child and right tree left child
# if same we say the tree is symmteric

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        self.isSym = True

        self.checkTree(root.left, root.right)

        return self.isSym

    def checkTree(self, rLeft, rRight):

        if rLeft is None and rRight is not None or rLeft is not None and rRight is None:
            self.isSym = False
            return None

        if rLeft is None or rRight is None:
            return None

        self.checkTree(rLeft.left, rRight.right)
        if rLeft.val != rRight.val:
            self.isSym = False
            return None
        self.checkTree(rLeft.right, rRight.left)


# breadth first search

# Time Complexity : O(n)
# space complexity : O(n)

# Approach :
# use bfs
# keep a boolean flag which keeps a track of the tree.
# we compare the following values
# left tree left child and right tree right child
# left tree right child and right tree left child
# if same we say the tree is symmteric


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        self.isSym = True
        self.bfs(root.left, root.right)

        return self.isSym

    def bfs(self, rootLeft, rootRight):

        queue = deque()
        queue.append(rootLeft)
        queue.append(rootRight)

        while queue:

            poppedItemLeft = queue.popleft()
            poppedItemRight = queue.popleft()

            if poppedItemLeft is None and poppedItemRight is None:
                continue

            if poppedItemLeft is None or poppedItemRight is None:
                self.isSym = False
                return None

            if poppedItemLeft.val != poppedItemRight.val:
                self.isSym = False
                return None

            queue.append(poppedItemLeft.left)
            queue.append(poppedItemRight.right)
            queue.append(poppedItemLeft.right)
            queue.append(poppedItemRight.left)
