# Created by Aashish Adhikari at 1:09 PM 1/15/2021


'''
Time Complexity:
At each node, we are creating a deep copy of the current path.
If k is the average length of the path upto a node in the tree, O( n. k)

Space Complexity:
Creating new lists at each node. Hence, O ( n . 2 . k)


'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def helper(self, node, current_path):


        if node.left is None and node.right is None:

            if sum(current_path) == self.sum:
                self.paths.append(current_path)

        a = copy.deepcopy(current_path)

        b = copy.deepcopy(current_path)


        if node.left is not None:
            a.extend([node.left.val])
            self.helper(node.left, a)
        if node.right is not None:
            b.extend([node.right.val])
            self.helper(node.right, b)




    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """


        if root is None:
            return []

        self.sum = sum
        self.paths = []

        self.helper(root, [root.val])

        return self.paths


