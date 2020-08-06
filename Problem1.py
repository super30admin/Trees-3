#Trees-3 
#Problem1 : https://leetcode.com/problems/path-sum-ii/
#All test cases passed on Leetcode
#Time Complexity: O(N^2) where N are the number of nodes in a tree. In the worst case, we could have a complete binary tree and if that is the case, then there would be N/2 leafs. For every leaf, we perform a potential O(N) operation of copying over the temp to a new list to be added to the result List. Hence, the complexity in the worst case could be O(N^2)
#Space Complexity: O(N^2).
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        #   attributes of this class to maintain global
        self.result = []
        
        
       
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        self.target=sum
        if root==None:
            return self.result
        self.dfs(root,0,[])
        return self.result
    
        

    
    def dfs(self,root,currSum,temp):
        
        #base
        if root==None:
            return
        currSum+=root.val
        print(currSum)
        temp.append(root.val)
        #print(root.val)
        if root.left==None and root.right==None:
            if self.target==currSum:
                # print(temp)
                # print(list(temp))
                self.result.append(list(temp))
                # print(self.result)
        self.dfs(root.left,currSum,list(temp))
        self.dfs(root.right,currSum,list(temp))


        
        
        