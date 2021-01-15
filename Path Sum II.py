# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    #Solution 1
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        #Approach: Recursion w/ backtracking
        #Time Complexity: O(n) // visiting every node exactly once
        #Space Complexity: O(h) // path can only be as long as the height
        
        self.result = []
        self.target = sum
        
        if not root:
            return self.result
        
        path = []
        self.helper(root, 0, path)
        return self.result
        
    def helper(self, root, currSum, path):
        #base
        if not root:
            return
        
        #logic
        currSum += root.val
        path.append(root.val)
        
        if not root.left and not root.right and currSum == self.target:
            self.result.append(path.copy())
            
        self.helper(root.left, currSum, path)
        self.helper(root.right, currSum, path)
        
        path.pop() #backtracking
    
    #Solution 2
    """
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        #Approach: Recursion w/o backtracking
        #Time Complexity: O(n^2) // deep-copying path at every node
        #Space Complexity: O(n^2) // deep-copying path at every node
        
        self.result = []
        self.target = sum
        
        if not root:
            return self.result
        
        path = []
        self.helper(root, 0, path)
        return self.result
        
    def helper(self, root, currSum, path):
        #base
        if not root:
            return
        
        #logic
        currSum += root.val
        path.append(root.val)
        
        if not root.left and not root.right and currSum == self.target:
            self.result.append(path)
            
        self.helper(root.left, currSum, path.copy())
        self.helper(root.right, currSum, path.copy())
    """
    
    #Solution 3
    """
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        #Approach: Iterative w/ backtracking
        #Time Complexity: O(n) // visiting every node exactly once
        #Space Complexity: O(h) // path can only be as long as the height
        
        result = []
        
        if not root:
            return result
        
        st = []
        currSum = 0
        path = []
        while root or st:
            while root:
                currSum += root.val
                path.append(root.val)
                st.append((root, currSum, path.copy())) #remove copy() when backtracking
                
                root = root.left
            
            root, currSum, path = st.pop()
            if not root.left and not root.right and currSum == sum:
                result.append(path.copy())
            
            root = root.right
            
        return result
    """