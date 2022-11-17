"""
FAANMG Problem #49 {Easy}

101. Symmetric Tree

Time Complexity : O(N)


Space Complexity : O(H)


Did this code successfully run on Leetcode : Yes

DFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def dfs(self,left, right):
        #base
        # checking if we have reached null, which is the end of the tree
        if(left is None and right is None):
            return
        
        # Checking if either of the nodes is not null, then tree is not symmetric
        if(left is None or right is None or left.val != right.val ):
            self.flag = False
            return
            
        
        #logic
        if self.flag:
            self.dfs(left.left, right.right)

        if self.flag:
            self.dfs(left.right, right.left)

        
        
        
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        self.flag = True
        
        if not root:
            return self.flag
        
        # calling the dfs helper function on root.left and root.right subtree
        self.dfs(root.left, root.right)
        
        return self.flag


"""
FAANMG Problem #49 {Easy}

101. Symmetric Tree

Time Complexity : O(N)


Space Complexity : O(H)


Did this code successfully run on Leetcode : Yes

DFS Solution - Iterative

@name: Rahul Govindkumar_RN27JUL2022
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
 
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        if not root:
            return True
        
        st = collections.deque()
        
        #Adding both the left and the right sub nodes to the stack
        st.append(root.left)
        st.append(root.right)
        
        
        while st:
            
            #Pop out tleft and right nodes
            left = st.pop()
            right = st.pop()
            
            
            #if Both the nodes are Null, meaning we have reached the end of leaf nodes
            if(left is None and right is None):
                continue
             
        #Either one of the Node is Null or Value is not same then it is not symetric 
            if(left is None or right is None or left.val != right.val):
                return False
            
            #Adding the pair of extremes together
            st.append(left.left)
            st.append(right.right)
            
            st.append(left.right)
            st.append(right.left)
            

        return True
        
        
        
        
        
        
        
        
"""
FAANMG Problem #49 {Easy}

101. Symmetric Tree

Time Complexity : O(N)


Space Complexity : O(H)


Did this code successfully run on Leetcode : Yes

BFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""        
        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
 
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        if not root:
            return True
        
        q = collections.deque()
        
        #Adding both the left and the right sub nodes to the queue
        q.append(root.left)
        q.append(root.right)
        
        
        while q:
            
            #Pop out tleft and right nodes
            left = q.popleft()
            right = q.popleft()
            
            
            #if Both the nodes are Null, meaning we have reached the end of leaf nodes
            if(left is None and right is None):
                continue
             
        #Either one of the Node is Null or Value is not same then it is not symetric 
            if(left is None or right is None or left.val != right.val):
                return False
            
            #Adding the pair of extremes together
            q.append(left.left)
            q.append(right.right)
            
            q.append(left.right)
            q.append(right.left)
            
            
            
            
        
       
        
        return True
        
        
        
        
                
        