# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    """BackTracking on both current sum and array
    Time complexity-O(n) as we are not copying array at each node, 
    we just copy when the totalsum  from root to leaf is equal to targetsum
    Space Complexity-O(n)"""
    def __init__(self):
        self.arr=[]
        self.cursum=0
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        arr1=[]
        self.helper(root, targetSum,arr1)
        return self.arr
    def helper(self, root, targetSum, arr1):
        if not root:
            return
        self.cursum+=root.val
        arr1.append(root.val)
        self.helper(root.left, targetSum, arr1)
        if not root.left and not root.right:
            if targetSum==self.cursum:
                self.arr.append(arr1[:])
        self.helper(root.right, targetSum, arr1)
        self.cursum-=root.val
        arr1.pop()
        
        
        """BackTracking on array only
    Time complexity-O(n) as we are not copying array at each node, 
    we just copy when the totalsum  from root to leaf is equal to targetsum
    Space Complexity-O(n)"""
    # def __init__(self):
    #     self.arr=[]
    # def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
    #     arr1=[]
    #     self.helper(root, 0, targetSum,arr1)
    #     return self.arr
    # def helper(self, root, cursum, targetSum, arr1):
    #     if not root:
    #         return
    #     cursum+=root.val
    #     arr1.append(root.val)
    #     self.helper(root.left,cursum, targetSum, arr1)
    #     if not root.left and not root.right:
    #         if targetSum==cursum:
    #             self.arr.append(arr1[:])
    #     self.helper(root.right, cursum, targetSum, arr1)
    #     arr1.pop()
        
        
    
    """Recursion
    Time complexity-O(n*n) as we are copying array at each node
    Space complexity-O(n*n) as we are copying array at each node"""
    # def __init__(self):
    #     self.arr=[]
    # def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
    #     arr1=[]
    #     self.helper(root, 0, targetSum,arr1)
    #     return self.arr
    # def helper(self, root, cursum, targetSum, arr1):
    #     if not root:
    #         return
    #     cursum+=root.val
    #     arr1.append(root.val)
    #     self.helper(root.left,cursum, targetSum, arr1[:])
    #     if not root.left and not root.right:
    #         if targetSum==cursum:
    #             self.arr.append(arr1)
    #     self.helper(root.right, cursum, targetSum, arr1[:])
    
    
        
                
                
        