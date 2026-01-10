# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        if root == None:
            return []

        def helper(root, curr_result):

            curr_result.append(root.val)
            curr_sum=sum(curr_result)


            if(curr_sum == targetSum and root.left == None and root.right == None):
                self.final_result.append(curr_result[:])

            if(root.left):
                helper(root.left, curr_result)

            if(root.right):
                helper(root.right, curr_result)


            curr_result.pop()





        self.final_result = []

        helper(root,[])

        return self.final_result

