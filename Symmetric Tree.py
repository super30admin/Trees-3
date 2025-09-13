# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Solution 1: Void based Recursion (Brute force/Non-conditional)
Helper recursive function takes left tree's root and right tree's root as parameter of 
recursion. We check if they both are leaf nodes. then return back. If only one of them
is Null pointer or their values are not equal then we set the global flag to False. 
Recursion is called on (left_tree's left, right_tree's right) and 
(left_tree's right, right_tree's left)
Time complexity: O(N) 
Space Complexity: O(N/2)=O(N), leaf_nodes = N/2 when perfect tree, recursive stack. 
'''
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root==None:
            return True
        self.isSymmetric_flag = True
        self.helper(root.left, root.right)
        
        return self.isSymmetric_flag

    def helper(self,leftTree_root, rightTree_root):
        # base
        if leftTree_root==None and rightTree_root==None: # leaf node on both side of tree
            return
        # logic
        # if either of the sides of tree's root is null or they are not null but at the same time
        # not equal, then not symmetric
        if leftTree_root == None or rightTree_root == None or leftTree_root.val!=rightTree_root.val:
            self.isSymmetric_flag = False
            return

        self.helper(leftTree_root.left, rightTree_root.right)
        self.helper(leftTree_root.right, rightTree_root.left)


'''
Solution 2: Void based Recursion (conditional-Early Stopping)
Helper recursive function takes left tree's root and right tree's root as parameter of 
recursion. We check if they both are leaf nodes. then return back. If only one of them
is Null pointer or their values are not equal then we set the global flag to False. 
Recursion is called on (left_tree's left, right_tree's right) and 
(left_tree's right, right_tree's left)
Time complexity: O(N) 
Space Complexity: O(N/2)=O(N), leaf_nodes = N/2 when perfect tree, recursive stack. 
'''
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root==None:
            return True
        self.isSymmetric_flag = True
        self.helper(root.left, root.right)
        
        return self.isSymmetric_flag

    def helper(self,leftTree_root, rightTree_root):
        # base
        if leftTree_root==None and rightTree_root==None: # leaf node on both side of tree
            return
        # logic
        # if either of the sides of tree's root is null or they are not null but at the same time
        # not equal, then not symmetric
        if leftTree_root == None or rightTree_root == None or leftTree_root.val!=rightTree_root.val:
            self.isSymmetric_flag = False
            return
        if self.isSymmetric_flag:
            self.helper(leftTree_root.left, rightTree_root.right)
        if self.isSymmetric_flag:
            self.helper(leftTree_root.right, rightTree_root.left)

'''
Solution 3: Boolean based Recursion (Brute force/Non-conditional)
Helper recursive function takes left tree's root and right tree's root as parameter of 
recursion. We check if they both are leaf nodes. then return True and go back. If only one of them
is Null pointer or their values are not equal then we return False. 
Recursion is called on (left_tree's left, right_tree's right) and 
(left_tree's right, right_tree's left)
Time complexity: O(N) 
Space Complexity: O(N/2)=O(N), leaf_nodes = N/2 when perfect tree, recursive stack. 
'''
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root==None:
            return True
        
        return self.helper(root.left, root.right)
        
    def helper(self,leftTree_root, rightTree_root):
        # base
        if leftTree_root==None and rightTree_root==None: # leaf node on both side of tree
            return True
        # logic
        # if either of the sides of tree's root is null or they are not null but at the same time
        # not equal, then not symmetric
        if leftTree_root == None or rightTree_root == None or leftTree_root.val!=rightTree_root.val:
            return False
        
        case1 = self.helper(leftTree_root.left, rightTree_root.right)
        
        case2 = self.helper(leftTree_root.right, rightTree_root.left)

        return case1 and case2

'''
Solution 4: Boolean based Recursion (Conditional-Early Stopping)
Helper recursive function takes left tree's root and right tree's root as parameter of 
recursion. We check if they both are leaf nodes. then return True and go back. If only one of them
is Null pointer or their values are not equal then we return False. 
Recursion is called on (left_tree's left, right_tree's right) and 
(left_tree's right, right_tree's left)
Time complexity: O(N) 
Space Complexity: O(N/2)=O(N), leaf_nodes = N/2 when perfect tree, recursive stack. 
'''
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root==None:
            return True
        
        return self.helper(root.left, root.right)
        
    def helper(self,leftTree_root, rightTree_root):
        # base
        if leftTree_root==None and rightTree_root==None: # leaf node on both side of tree
            return True
        # logic
        # if either of the sides of tree's root is null or they are not null but at the same time
        # not equal, then not symmetric
        if leftTree_root == None or rightTree_root == None or leftTree_root.val!=rightTree_root.val:
            return False
        
        # Early-Stopping: if first recursive calls returns False, second recursive call is not Done
        return self.helper(leftTree_root.left, rightTree_root.right) and self.helper(leftTree_root.right, rightTree_root.left)

'''
Solution 5: Iterative solution (DFS) 
We maintain a stack. The left_tree_node and right_tree_node goes in pair. Since this
is LIFO (Last in First out), right_tree's node comes out first.
Before inserting into stack, We check if they both are leaf nodes. then we just continue 
If only one of them is Null pointer or their values are not equal then we return False. 
Nodes are inserted into stack in this order (left_tree's left, right_tree's right) and 
(left_tree's right, right_tree's left)
Time complexity: O(N) 
Space Complexity: O(h), where h=height of tree, worst case O(N), best case O(logN) 
'''
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root==None:
            return True
        
        dfs_stack = []
        dfs_stack.append(root.left)
        dfs_stack.append(root.right)

        while (len(dfs_stack)!=0):
            right_tree_root = dfs_stack.pop() # since stack, LIFO, right tree goes last, comes out first
            left_tree_root = dfs_stack.pop()

            if right_tree_root==None and left_tree_root==None: # leaf node
                continue
            
            if right_tree_root==None or left_tree_root==None or right_tree_root.val!=left_tree_root.val:
                return False # found breach
            
            dfs_stack.append(left_tree_root.left)
            dfs_stack.append(right_tree_root.right)

            dfs_stack.append(left_tree_root.right)
            dfs_stack.append(right_tree_root.left)
        
        return True

'''
Solution 6: Iterative solution (BFS) 
We maintain a queue. The left_tree_node and right_tree_node goes in pair. Since this
is FIFO (First in First out), left_tree's node comes out first.
Before inserting into queue, We check if they both are leaf nodes, if they are then we just continue 
If only one of them is Null pointer or their values are not equal then we return False. 
Nodes are inserted into queue in this order (left_tree's left, right_tree's right) and 
(left_tree's right, right_tree's left)
Time complexity: O(N) 
Space Complexity: O(N),  
'''
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root==None:
            return True
        
        bfs_queue = deque()
        bfs_queue.append(root.left)
        bfs_queue.append(root.right)

        while (len(bfs_queue)!=0):
            left_tree_root = bfs_queue.popleft() # since queue, FIFO, left tree goes first, comes out first
            right_tree_root = bfs_queue.popleft() 

            if right_tree_root==None and left_tree_root==None: # leaf node
                continue
            
            if right_tree_root==None or left_tree_root==None or right_tree_root.val!=left_tree_root.val:
                return False # found breach
            
            bfs_queue.append(left_tree_root.left)
            bfs_queue.append(right_tree_root.right)

            bfs_queue.append(left_tree_root.right)
            bfs_queue.append(right_tree_root.left)
        
        return True
