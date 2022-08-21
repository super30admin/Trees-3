# Time Complexity :O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        def path2(root, arr,arrsum, target):
            
            if root is None:
                return
            # temp = arr
            arr.append(root.val)
            if root.left is None and root.right is None:
                if target == arrsum+root.val:
                    temp = copy.deepcopy(arr)
                    result.append(temp)
                    
            path2(root.left, arr, arrsum+root.val,target)
            path2(root.right, arr, arrsum+root.val,target)
            arr.pop()
            
        result = []
        path2(root,[],0,targetSum)
        return result