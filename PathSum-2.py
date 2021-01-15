# Recursion: Making deep copy of paths to maintain path for each node
# TC & SC: O(N2)
# We traverse through each node and at each node, we form new paths to retrieve actual path at each node  
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root, sum):
        self.result = []
        self.target = sum
        if root == None: return self.result
        self.helper(root, 0, [])
        return self.result
    
    def helper(self, root, currSum, path):
        # base
        if root == None:
            return
        # logic 
        currSum += root.val
        path.append(root.val)
        if root.left == None and root.right == None:
            if currSum == self.target:
                self.result.append(path)
        # recursion
        # deep copy of prev path used at each node
        self.helper(root.left, currSum, path.copy())
        self.helper(root.right, currSum, path.copy())

# Backtrack
# TC & SC: O(N)
# We are saving time n space by using backtrack strategy where in we remove last element(if leaf node) from the path before going to right or before jumping to ancestor node. So this allows us to retrieve actual path at given node when sum is found. 
class Solution:
    def pathSum(self, root, sum):
        self.result = []
        self.target = sum
        if root == None: return self.result
        self.helper(root, 0, [])
        return self.result
    
    def helper(self, root, currSum, path):
        # base
        if root == None:
            return
        # logic 
        currSum += root.val
        path.append(root.val)
        if root.left == None and root.right == None:
            if currSum == self.target:
                self.result.append(path.copy())
        # recursion
        self.helper(root.left, currSum, path)
        self.helper(root.right, currSum, path)
        
        #backtrack
        path.pop(len(path)-1)

