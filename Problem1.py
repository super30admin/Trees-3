#Time Complexity : O(n) - Visiting each node of the Tree in worst case
#Space Complexity : O(n) - For the recursive stack and the path array which O(n) total.

def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = [] 
        #If root as input is null
        if root == None:
            return self.result
        
        self.helper(root, 0, targetSum, [])
        return self.result
    
    def helper(self, root, curSum, targetSum, path):
        
        #Base
        if root == None:
            return
        
        #Logic
        path.append(root.val)
        curSum += root.val
        
        if root.left == None and root.right == None:
            if curSum == targetSum:
                self.result.append(path[:])
                
        self.helper(root.left, curSum, targetSum, path)
        self.helper(root.right, curSum, targetSum, path)
        
        path.pop()