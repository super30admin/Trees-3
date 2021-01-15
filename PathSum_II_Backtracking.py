# Created by Aashish Adhikari at 1:18 PM 1/15/2021

'''
Time Complexity:
Ignoring the deepcopy operation when a viable path is found, O(n).
Considering those operations, in the worst case, all the leaves with give a viable path. Since there will be a max of O( 2 ^ h)  leaves, TC :  O(n + 2 ^ h)

Space Complexity:
O(n) since in the worst case, we will add all elements to the array variable that stores the current path.
'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right



class Solution(object):

    def backtrack(self, node, current_path_upto_parent, sum_upto_parent):



        # base case
        current_path_upto_parent.append(node.val)
        sum_upto_parent += node.val
        if node.left is None and node.right is None:

            if sum_upto_parent == self.sum:
                self.paths.append(copy.deepcopy(current_path_upto_parent))



        # recursion
        if node.left is not None:
            self.backtrack(node.left, current_path_upto_parent, sum_upto_parent)     #<-- this traversal does not affect the state of the current path when it returns back

        if node.right is not None:
            self.backtrack(node.right, current_path_upto_parent, sum_upto_parent)    #<-- this traversal does not affect the state of the current path when it returns back

        # backtracking
        # once recursion returns from both the children, remove the current node element from the path since it returns the recursion to its parent
        current_path_upto_parent.pop()

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

        self.backtrack(root, [], 0)

        return self.paths