# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        ret=[]
        path=[]
        self.recurr(root,path,ret,0,sum)
        return ret
    
    def recurr(self, root, path, ret, currSum, sum):
        if not root: return 
        if root.left is None and root.right is None:
            if currSum+root.val==sum:
                temp=path[:]
                temp.append(root.val)
                ret.append(temp)
            return
        path.append(root.val)
        self.recurr(root.left,path,ret,currSum+root.val,sum)
        self.recurr(root.right,path,ret,currSum+root.val,sum)
        path.pop()