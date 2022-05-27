#Time Complexity : O(N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.li = []
        self.helper(root,[],0,targetSum)
        print(self.li)
        return self.li
        
    def helper(self,root,path,summ,target):
        if root is None:
            return
        summ += root.val
        path.append(root.val)
        if root.left == None and root.right == None:
            if summ == target:
                self.li.append(list(path))
                return
        #logic
        self.helper(root.left,list(path),summ,target)
        self.helper(root.right,list(path),summ,target)
        del path[-1]