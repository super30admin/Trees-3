# Time Complexity: O(N)
# Space Complexity: O(h) if we count the output array as extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Here we travel to the leaves of every node and if the total is equal to the targetSum append it
# to the result
class Solution:
    # Backtracking Solution
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root==None:
            return []
        result = list()

        def dfsCheck(root,curr_sum,path):
            if root==None:
                return
            # if path is None:
            #     path = list()

            #decision
            path.append(root.val)

            if root.left==None and root.right==None:
                # path.append(root.val)
                curr_sum = curr_sum+root.val
                if curr_sum==targetSum:
                    #here we create a new path list since the list is passed by ref
                    # at the end when the backtracking is over, path is empty
                    # and it would show empty in the list as well
                    result.append(path[::])
                path.pop()
                return

            left = dfsCheck(root.left,curr_sum+root.val,path)
            right = dfsCheck(root.right,curr_sum+root.val,path)

            #backtrack
            path.pop()

        dfsCheck(root,0,[])
        return result


    # Helper function inside the main:Recursive
#     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
#         if root==None:
#             return []
#         result = list()

#         def dfsCheck(root,curr_sum,path):
#             if root==None:
#                 return
#             # if path is None:
#             #     path = list()

#             # path.append(root.val)

#             if root.left==None and root.right==None:
#                 path.append(root.val)
#                 curr_sum = curr_sum+root.val
#                 if curr_sum==targetSum:
#                     result.append(path)
#                 return

#             # we use path+[root.val] since path.append(root.val) returns None in python
#             # left = dfsCheck(root.left,curr_sum+root.val,list(path))
#             left = dfsCheck(root.left,curr_sum+root.val,path+[root.val])
#             # right = dfsCheck(root.right,curr_sum+root.val,list(path))
#             right = dfsCheck(root.right,curr_sum+root.val,path+[root.val])

#         dfsCheck(root,0,[])
#         return result

    # Function outside of main function
#     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
#         if root==None:
#             return []
#         result = list()
#         self.dfsCheck(root,0,[],targetSum,result)
#         return result

#     def dfsCheck(self,root,curr_sum,path,targetSum,result):
#         if root==None:
#             return
#         if path is None:
#             path = list()

#         # path.append(root.val)

#         if root.left==None and root.right==None:
#             path.append(root.val)
#             curr_sum = curr_sum+root.val
#             if curr_sum==targetSum:
#                 result.append(path)
#             return

#         # left = dfsCheck(root.left,curr_sum+root.val,list(path))
#         left = self.dfsCheck(root.left,curr_sum+root.val,path+[root.val],targetSum,result)
#         # right = dfsCheck(root.right,curr_sum+root.val,list(path))
#         right = self.dfsCheck(root.right,curr_sum+root.val,path+[root.val],targetSum,result)