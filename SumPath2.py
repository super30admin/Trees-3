
  ---------------------- SumPath2----------------------------Recursively Approach--------------------   
# Time Complexity : O(Log N) N is the number of nodes.
# Space Complexity : O(Log N) N is the number of nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here while I am iterating I am appending the number of that node value to temp, 
#Once I reach the leaf node and when my sum is equal to the target given I am appending my entire temp array to res, else I am recursively iterating to left and right elements.

class Solution:
    def pathSum(self, root: TreeNode, s: int) -> List[List[int]]:
        if not root:
            return None
        
        def dfs(root, temp, total):
            if not root:
                return 
            else:
                temp.append(root.val)
                total += root.val
                if not root.left and not root.right and total == s:
                    res.append(temp[:])
                else:
                    dfs(root.left, temp, total) 
                    dfs(root.right, temp, total)
                temp.pop()
        
        res = []
        dfs(root, [], 0)
        return res
        
  ---------------------- Path Sum 2 Iteratively------------------------------------------------   
# Time Complexity : O(Log N) N is the number of nodes.
# Space Complexity : O(Log N) N is the number of nodes using dict
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

 #Here while I am iterating I am appending the number of that node value to temp, 
#Once I reach the leaf node and when my sum is equal to the target given I am appending my entire temp array to res, else I am  iterating to left and right elements using stack.

      
class Solution:
    def pathSum(self, root: TreeNode, s: int) -> List[List[int]]:
        if not root:
            return []
        
        res = []
        stack = [(root, [root.val], s)]
        while queue:
            curr, temp, total = stack.pop()

            if not curr.left and not curr.right and curr.val == total:
                res.append(temp)
            if curr.left:
                queue.append((curr.left, temp+[curr.left.val],total-curr.val))
            if curr.right:
                queue.append((curr.right,temp+[curr.right.val], total-curr.val))

        return res