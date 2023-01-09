#time complexity: O(n^2)
#space complexity: O(n)
#ran on leetcode: Yes
#do a dfs on the tree. At each node, add the current node to the already existing path
# and increment the sum by node.val. If the sum equlas target and current node is leaf
#node then add the path to final output.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self,root,path,path_sum,target):
        if(root==None):
            return
        path_sum+=root.val
        path_new=path[:]
        path_new.append(root.val)
        if(path_sum==target):
            if(root.left==None and root.right==None):
                self.ans.append(path_new)
                return
        
        self.dfs(root.left,path_new,path_sum,target)
        self.dfs(root.right,path_new,path_sum,target)
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.ans=[]
        self.dfs(root,[],0,targetSum)
        return self.ans
