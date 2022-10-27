# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # leetcode URL : https://leetcode.com/problems/path-sum-ii/
    # Problem : 113. Path Sum II
    # Time Complexity : O(n)
    # Space Complexity : O(n)
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        stack = list()
        stack.append((root,list(),0))
        ret_list = list(list())
        
        while stack:
            top = stack.pop()
            if top[0] == None:
                continue
            if top[0].left == None and top[0].right == None:
                if (top[2]+top[0].val) == targetSum:
                    ret_list.append(top[1]+[top[0].val])
            else:
                stack.append((top[0].right,top[1]+[top[0].val],top[2]+top[0].val))
                stack.append((top[0].left,top[1]+[top[0].val],top[2]+top[0].val))
        return ret_list
            