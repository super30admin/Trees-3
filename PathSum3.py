
#Time Comp: O(n^2)
#Space: O(h*n) 
#h is height of the tree and n is the number of times we will create a new list  



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        currList =[]
        self.helper(root, currList, 0, targetSum)
        return self.result

    def helper(self,root, currList, currSum, target):
        if root is None:
            return 

        currSum += root.val
        path =[]
        
        path.extend(currList)
        path.append(root.val)
        #print("currList", currList)
        #print("path", path)
              
        if root.left == None and root.right == None:
            if currSum == target:
                #print("currSum", currSum)
                #path.append(currList)
                self.result.append(path)
        #print(self.result)
        
        self.helper(root.left, path, currSum, target)
        self.helper(root.right, path, currSum, target)
        