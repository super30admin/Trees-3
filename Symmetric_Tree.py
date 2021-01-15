# Created by Aashish Adhikari at 2:48 PM 1/15/2021


'''

Time Complexity:
O(n) since each node is reached once.

Space Complexity:
O( 2 ^ h) where h is the height of the tree since we store a maximum of 2^h elements at any given time in queue as well as array.

'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        if root is None:
            return True


        from collections import deque

        q = deque()
        q.append(root)

        next_level = []
        while len(q) != 0:

            num_of_nodes = len(q)

            for idx in range(0, num_of_nodes):

                if q[0].left is not None:

                    q.append(q[0].left)
                    next_level.append(q[0].left.val)
                else:
                    next_level.append("Null")

                if q[0].right is not None:

                    q.append(q[0].right)
                    next_level.append(q[0].right.val)
                else:
                    next_level.append("Null")

                q.popleft()

            for idx in range(0, len(next_level)//2):

                if next_level[idx] != next_level[len(next_level)-1-idx]:
                    return False

            next_level = []



        return True




