#Time Complexity :O(n) 
#Space Complexity :o(n) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    result=None
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if(root==None):
            return
        
        self.result=[]
        currSum=0
        arr=[]
        self.helper(root,currSum,sum,arr)
        return self.result
    
    
    def helper(self,root,currSum,target,arr):
        if(root==None):
            return
        
        currSum+=root.val
        arr.append(root.val)
        if(root.left==None and root.right==None):
            if(currSum==target):
                self.result.append(copy.deepcopy(arr))
                
        self.helper(root.left,currSum,target,arr)
        self.helper(root.right,currSum,target,arr)
        arr.pop()
        
        
        
        