#time: O(n)
#Space: O(height of recursive stack)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.arr= list()
        self.path = list()
        self.dfs(root,path,0, targetSum)

        return self.arr

    def dfs(self, root, path,cs, targetSum):
        if root is None:
            return
        self.path.append(root.val)
        cs= cs + int(root.val)
        print('cs', cs, 'targetSum', targetSum)
        if (root.left is None and root.right is None and cs == targetSum):
            print('condition matches')
            self.arr.append(list(self.path))
            # return
            
        self.dfs(root.left, path, cs, targetSum)
        self.dfs(root.right, path, cs, targetSum)
        self.path.pop()        
        
        
        
