# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        
        """
        Description: Given the root of a binary tree and an integer targetSum, return all root-to-leaf path
        
        Time Complexicity: O(n), where n are the number of elements in the binary tree
        Space Complexicity: O(h), where h is height of the tree
        
        Approach:
        1. Maintain a list of global variable (for result)
        2. Recursive call for keeping sum and current list from the root of the tree
        3. Create a copy of the sub-array if the sum matches with the target and append to the results
        4. In each recursive call pop the elements from the list (optimizes time complexicity)
        """
        
        if root == None: return []
        self.allpaths = []
        self.target = targetSum
        return self.helper(root, 0, [])
    
    def helper(self, root, currSum, sumList):
        
        # Base Case
        if root == None: return 
        
        # Logic
        currSum += root.val
        sumList.append(root.val)
        
        if root.left == None and root.right == None:
            if sum(sumList) == self.target:
                # print(sumList)
                self.allpaths.append(copy.copy(sumList))
                
        self.helper(root.left, currSum, sumList)
        self.helper(root.right, currSum, sumList)
        
        sumList.pop()
        
        return self.allpaths
