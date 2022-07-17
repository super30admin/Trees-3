# Time Complexity: O(N)
# Space Comlexity: O(N)
# Approach: traverse the tree and have a current sum, if the node is leaf node,
# and if the current sum is equal to target, copy the traversed path list to new list 
# and append it to the result


class Solution:
    result=[]
    path = []
    def pathSum(self, root, targetSum: int):
        self.result=[]
        self.helper(root,0,targetSum)
        return self.result
    def helper(self,root,currentSum,targetSum):
        if root== None:
            return
        self.path.append(root.val)
        if root.left==None and root.right==None and currentSum+root.val==targetSum:
            self.result.append(self.path.copy())
        self.helper(root.left,currentSum + root.val,targetSum)
        self.helper(root.right,currentSum + root.val,targetSum)
        self.path.pop() 
        