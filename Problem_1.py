# Time Complexity : O(N) 
# Space Complexity : O(H) ~> For Stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    
    def __init__(self):
        self.result = []
        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        if not root:
            return []
        
        def recur(root, number, combi):
            if root.left == None and root.right == None:
                curr = number + root.val
                if curr == targetSum:
                    self.result.append(combi + [root.val])
            
            curr = number + root.val
            combi.append(root.val)
            
            if root.left:
                recur(root.left, curr, combi)
            
            if root.right:
                recur(root.right, curr, combi)
            
            combi.pop()
            
            

        recur(root, 0, [])
        return self.result