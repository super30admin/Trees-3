# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#time complexity: O(n)
#space complexity: O(h)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result=[]
        if root==None: return result
        
        def helper(r, targetSum, currsum, path):
            if root==None: return
            currsum=currsum+root.val
            path.append(root.val)
            print(path)
            if(root.left==None and root.right==None):
                if currsum==targetSum:
                    result.append([path])   
            helper(root.left, targetSum, currsum, path)
            helper(root.right, targetSum, currsum, path)   
            path.remove(len(path)-1)
                    
                    
        helper(root, targetSum, 0, [])
        return result