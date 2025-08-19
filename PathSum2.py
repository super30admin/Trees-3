# Time Complexity : It is O(n) since we are iterating with all nodes.
# Space Complexity : It is O(h) height of the tree.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List
class Solution:
    result =[[]]
    def rootToLeave(self, root: Optional[TreeNode], targetSum: int, lstTargetSum : List[int], sumofNodes : int):
        #base
        if(root==None): 
            return

        sumofNodes = sumofNodes + root.val 
        localList = list(lstTargetSum)
    
        localList.append(root.val)

        if(root.left==None and root.right==None and sumofNodes==targetSum):
       
            Solution.result.append(localList)


        #logic
        self.rootToLeave(root.left,targetSum,localList,sumofNodes)

        self.rootToLeave(root.right,targetSum,localList,sumofNodes)

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        Solution.result =[]
        self.rootToLeave(root,targetSum,[],0)
        return Solution.result
        