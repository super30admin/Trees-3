'''
Time complexity: O(n+diameter)
Space complexity: O(max_depth + diameter)
'''
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        output = []   
        path = []    
        self.recurr(root, targetSum, 0, output, path)
        return output

    def recurr(self, root, targetSum, currentSum, output, path):
        if root is None:    
            return

        currentSum = currentSum + root.val 
        path.append(root.val) 
        
        if root.left is None and root.right is None:   
            if targetSum == currentSum:               
                temp = path.copy()
                output.append(temp)       
            path.pop()  
            print(path)
            return  

        self.recurr(root.left, targetSum, currentSum, output, path)
        self.recurr(root.right, targetSum, currentSum, output, path)
        path.pop()