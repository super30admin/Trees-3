# DFS Approach

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def isMirror(left, right):
            
            if (left == None and right == None):
                return True
            
            if left == None or right == None:
                return False
            
            return ((left.val == right.val) and isMirror(left.left, right.right) and isMirror(left.right, right.left))
        
        if not root:
            return True
        
        left = root.left
        right = root.right
        
        return isMirror(left, right)
            
    # Recursive Solution
    # Time complexity: O(n) n is the number of nodes
    # Space Complexity: O(H) H is the height of the tree

# BFS Approach

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        # Iterative approach
        
        queue = collections.deque()
        
        queue.append(root.left)
        queue.append(root.right)
        
        while queue:
            left = queue.popleft()
            right = queue.popleft()
            
            if left == None and right == None:
                continue
                
            if left == None or right == None:
                return False
            
            if left.val != right.val:
                return False
            
            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)
            
        return True
    
    # Time complexity: O(n)
    # Space Complexity: O(n) in the worst case
    # This is an iterative approach