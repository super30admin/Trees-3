#Time Complexity : O(n^2)
#Space Complexity : O(n^2)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        path = []
        self.helper(root, 0, path,targetSum)
        return self.result
    
    def helper(self,root,currSum,path,targetSum):
        
        if(root == None):
            return
        
        currSum += root.val
        print(currSum)
        path.append(root.val)
        if(root.left == None and root.right == None):
            if(currSum == targetSum):
                print(path)
                self.result.append(path)
        self.helper(root.left,currSum,path.copy(),targetSum)
        self.helper(root.right,currSum,path.copy(),targetSum)
