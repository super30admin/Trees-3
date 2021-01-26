#Time Complexity:O(n)
#Space Complexity:O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result=[]                                                                       #Creating the output array
    target=0                                                                        #Using a temp variable to compare targetSum
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
            self.result=[]                                                          
            if root==None:
                return self.result                                                  #if the tree is empty return the result
            self.target=targetSum                                                   #initializing the target variable
            self.helper(root,0,[])                                                  #calling the recursive function helper with the tree and initial sum 0
            return self.result                                                      #returning the result array after the backtracking
        
    def helper(self,root:TreeNode , cSum:int ,path:List[int] )->None:
        if root==None:                                                              #if the current root is null then return
            return
        cSum+=root.val                                                              #updating the current sum value wth root value
        path.append(root.val)                                                       #appening the root to the path taken
        if root.left==None and root.right==None:                                    #at any leaf node
            if cSum==self.target:                                                   #if the sum and target are equal
                self.result.append(path.copy())                                     #copy the path to the final result
        self.helper(root.left,cSum,path)                                            #find the sum of left subtree
        self.helper(root.right,cSum,path)                                           #find the sum of right subtree
        path.pop()                                                                  #remove the last node to backtrack