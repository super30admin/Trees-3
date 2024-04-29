# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)

# Approach
# Recrusively traverse through the left and right subtree. Pass root, curSum, list of all the visited nodes and targetSum 
# for each node, update curSum. If the node is a leaf node, check if the curSum == targetSum. If yes, append the visited node list to res list
# return res list

# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    # res = []
    def helper(self,root,curSum,li,targetSum):
        if root == None:
            return
        
        curSum = curSum + root.val
        li = li+[root.val]
      
        if root.left == None and root.right == None:
            if curSum == targetSum:
                self.res.append(li)
           
            
        self.helper(root.left,curSum,li,targetSum)
        self.helper(root.right,curSum,li,targetSum)

    
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []
        print(self.res)
        self.helper(root,0,[],targetSum)
        
        return self.res