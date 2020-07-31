'''
PROBLEM 1

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- travrse the tree calculating current sum upto that node, and also maintain path traversed to reach that node
- check if the current sum is equal to target sum and if the node is a leaf node, add path traversed to the result array
- return the result array

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if root==None:
            return None
        self.result=[]
        
        self.helper(root, sum, [], 0)
        
        return self.result
        
    def helper(self, root: TreeNode, sum: int, currArray: List[int], currSum):
        
        if root==None:
            return
        
        currSum+= root.val
        currArray.append(root.val)
        if root.left==None and root.right==None and currSum==sum:
            self.result.append(currArray)
        temp1=currArray.copy()
        temp2=currArray.copy()
        
        if root.left!=None:
            self.helper(root.left, sum, temp1, currSum)
        if root.right!=None:
            self.helper(root.right, sum, temp2, currSum)

'''
PROBLEM 2

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- pass the root left and right child to the helper function
- check if both the nodes are Null, then return true and if any one of them is not null and other is null, it means the tree is not symmetric and return False
- call the funtion on root.left, root.right and root.right, root.left

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root==None:
            return True
        return self.helper(root.left, root.right)
    
    def helper(self, node1, node2):
        if node1==None and node2==None:
            return True
        
        if node1==None or node2==None:
            return False
        
        if node1.val!=node2.val:
            return False
        
        return self.helper(node1.left, node2.right) and self.helper(node1.right, node2.left)