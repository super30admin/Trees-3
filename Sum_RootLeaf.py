'''
Time complexity: O(N^2)? Not sure though
Space complexity: O(N)
Challenges: Lots of errors
Executed in leetcode: Yes
Comments: Given below

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        # Sanity check
        if not root:return []
        
        # If left node, left and right node is none
        if not root.left and not root.right:
            # If value of leaf node is equal to sum, return the same. Else, an empty list
            if root.val == sum:return [[root.val]]
            else:return []
            
        # As we traverse, sum is equal to sum - value at node, such that we finally get the list of values adding upto the sum
        left_route = self.pathSum(root.left, sum - root.val)
        right_route = self.pathSum(root.right, sum - root.val)
        
        # We append the lists 
        result = [[root.val]+x for x in left_route + right_route]
        print("Left Path:",left_route, "\nRight path -",right_route, "\n",final_sum)
        return result
