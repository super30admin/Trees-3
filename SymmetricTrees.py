
  ---------------------- Symmetric Tree----------------------------Recursively Approach--------------------   
# Time Complexity : O(N) N is the number of nodes.
# Space Complexity : O(height) height is the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here every time I am taking 2 nodes in which I am checking weather the node values are same. In symmetric tree we have last 
#node equals to first node . so this sense, left.left node equals to right.right node. left.right is equal to right.left. 
#So in this way we will iterate through all the nodes of the tree.

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        
        def dfs(l, r):
            if not root:
                return 
            
            if not l and not r:
                return True
            
            if not l or not r:
                return False
    
            
            return l.val == r.val and dfs(l.left,r.right) and dfs(l.right, r.left)
    
        return dfs(root,root)
        
   ---------------------- Symmetric Tree Iteratively------------------------------------------------   
# Time Complexity : O(Log N) N is the number of nodes.
# Space Complexity : O(Log N) N is the number of nodes using dict
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

 #Here in iterative approach, I will repeat the same process as recursive approach. when ever i see no nodes, I will continue, if i see values not equal then i return False.
 #If equal, i will append left node left, right node right and left.right compared to right.left.
        
from collections import deque
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        
        queue = deque([(root,root)])
        while queue:
            l, r = queue.popleft()
            
            if not l and not r:
                continue
                
            if not l or not r:
                return False
            
            if l.val != r.val:
                return False
            
            queue.append((l.left,r.right))
            queue.append((l.right,r.left))
        return True