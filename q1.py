from typing import Optional,List
# Time Complexity : O(n), Where n is number of nodes in the binary tree
# Space Complexity : O(h), Where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def solution(self,root: TreeNode,s: int,ans: List[int],targetSum: int,sol: List[List[int]]):
        #Base Case
        if(root==None):
            return
        if(root.left==None and root.right==None):
            #This is a when we reach leaf node
            ans.append(root.val)
            s+=root.val
            if(s==targetSum):
                #This is when reached the required case, Therefore let us add copy of ans to the sol 
                #print(ans)
                sol.append(list(ans))
            ans.pop(-1)
            return
        #Actual Logic
        s+=root.val
        ans.append(root.val)
        self.solution(root.left,s,ans,targetSum,sol)
        ans.pop(-1)
        ans.append(root.val)
        self.solution(root.right,s,ans,targetSum,sol)
        ans.pop(-1)
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        sol=[]
        self.solution(root,0,[],targetSum,sol)
        #print(sol)
        return (sol)