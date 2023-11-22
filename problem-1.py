# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfs(root):
            if not root:
                return
        
            #If Node is Leaf
            if not root.left and not root.right:
                #Process the values
                finalSum = sum(subset) + root.val
                if finalSum == targetSum:
                    subset.append(root.val)
                    superset.append(subset.copy())
                    subset.pop()
                return
            
            subset.append(root.val)
            dfs(root.left)
            dfs(root.right)
            subset.pop()
        
        superset, subset = [], []
        dfs(root)

        return superset