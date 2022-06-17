#TC: O(n)
#SC: O(h*m) where h is the height of the path and m is no. of paths
#code using back tracking for the same list
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        
        def helper(root,currnum,currlist,target):
            
            if(root==None):return 
            currnum+=root.val
            currlist.append(root.val)
            helper(root.left,currnum,currlist,target)
            if(root.left==None and root.right==None):
                if(currnum==target):
                    result.append(currlist[:])
                    #print(currlist)
            helper(root.right,currnum,currlist,target)
            currlist.pop()
        
        result=[]
        currlist=[]
        helper(root,0,currlist,targetSum)
        return result


