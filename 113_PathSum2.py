


# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    
    def pathSum(self, root, targetSum: int) :
        root = TreeNode()
        result = []
        path = []
       
    
        def helper(root,currSum, path, target):
            if root==None:
                return
            currSum = currSum + root.val
            path.append(root.val)
#             here list is going with reference pointer in recursion, so pointer will be same , it will just add the value not removing 
# here we got 2 path, because of currSum is going currectly.
            if root.left == None and root.right ==  None:
                if currSum == target:
#  so problem was, there were same refrence, so make copy instead to just append, in result every copy has diffrent location 
#                    result.append(path)
                     result.append(path.copy())
            helper(root.left, currSum,path,target)
            helper(root.right, currSum,path,target)
            path.pop()
            
        helper(root,0, path, targetSum)
        return result
        
obj = Solution()
print(obj.pathSum([5,4,8],9))