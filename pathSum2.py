'''
time complexity: O(n)
space complexity: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        path = []
        self.dfsHelper(root,0,path,targetSum)
        return self.result
    def dfsHelper(self,root,currVal,path,targetSum):
        
        if root is None: return

        path.append(root.val)
        if root.left==None and root.right==None:

            currVal = currVal+ root.val
            if(currVal == targetSum):
              
                self.result.append(copy.deepcopy(path))
            
        
        self.dfsHelper(root.left,currVal+ root.val,path,targetSum)
        self.dfsHelper(root.right,currVal + root.val,path,targetSum)
        path.pop()