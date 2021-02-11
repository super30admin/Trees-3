#TimeComplexity:O(N) 
#SpaceComplexity: O(N + MaxDepth)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        output=[]
        result=[]
        def recur(root,count,targetSum,result):
            print('hi')
            nonlocal output
            if root==None:
                return
            count=count+root.val
            result.append(root.val)
            if root.left==None and root.right==None:
                if count==targetSum:
                    temp=result.copy()
                    output.append(temp)
                result.pop()
                return

            recur(root.left,count,targetSum,result)
            recur(root.right,count,targetSum,result)
            result.pop()
            #return output
        

        #return 
        recur(root,0,targetSum,result)
        return output


                
        