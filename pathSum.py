# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity: O(n)
#Space Complexity:O(h)
#Did it run successfully on Leetcode: Yes 
#Here I create a stack whcih will have the vales of the root I am operating on. 
# I will traverse through left and right node to check the sum of the all the nodes traversed is equal to the target once I find out the there is no left and right nodes exist. 
#Iterative solution:
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if not root:
            return []
        res=[]
        stack=[(root,[root.val])]
        while stack:
            curr,ls=stack.pop()
            
            if not curr.left and not curr.right and sum(ls)== s:
                res.append(ls)
            
            if curr.left:
                 stack.append((curr.left, ls+[curr.left.val]))
            if curr.right:
                  stack.append((curr.right, ls+[curr.right.val]))
        return res
    
#Recursive solution:

    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
             if not root:
                 return []
             res = []
             self.dfs(root, sum, [], res)
             return res
    
    def dfs(self, root, sum, ls, res):
        if not root.left and not root.right and sum == root.val:
            ls.append(root.val)
            res.append(ls)
        if root.left:
            self.dfs(root.left, sum-root.val, ls+[root.val], res)
        if root.right:
            self.dfs(root.right, sum-root.val, ls+[root.val], res)

    def pathSum2(self, root, sum):
        if not root:
            return []
        if not root.left and not root.right and sum == root.val:
            return [[root.val]]
        tmp = self.pathSum(root.left, sum-root.val) + self.pathSum(root.right, sum-root.val)
        return [[root.val]+i for i in tmp]
