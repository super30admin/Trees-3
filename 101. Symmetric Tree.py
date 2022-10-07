# DFS 
# TC - O(n)
# SC - O(h)

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        global flag
        def dfs(left,right):
            global flag
            #base
            if left == None and right == None: return
            if left == None or right == None or left.val != right.val:
                flag = False
                return
            #logic
            if flag:
                dfs(left.left , right.right)
            #st.pop()
            if flag:
                dfs(left.right , right.left)
        if root == None:
            return True
        flag = True
        dfs(root.left , root.right)
        return flag

#BFS + Queue
# TC - O(n)
# SC - O(n)

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None: 
            return True
        q = [root.left,root.right]
        
        while len(q) > 0:
            left = q.pop()
            right = q.pop()
            
            if left == None and right == None:
                continue
            if left == None or right == None or left.val != right.val:
                return False
            q.append(left.left)
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)
            
        return True

#
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        
        return self.helper(root.left,root.right)
    def helper(self,leftRoot,rightRoot):
        if leftRoot and rightRoot:
            return leftRoot.val == rightRoot.val and self.helper(leftRoot.left,rightRoot.right) and self.helper(leftRoot.right,rightRoot.left)
        return leftRoot == rightRoot



#

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
		# left part of first tree must be same as the right part of the second tree
		# right part of first tree must be same as the left part of the second tree

        return self.helper(root, root)

    def helper(self, node1, node2):
        if node1 == None and node2 == None:
                    # If both the trees are none then they are symmetrix
            return True
        if node1 == None or node2 == None:
                    # If one of them is None and other is not none then they are not symmetric
            return False
                # Finally check for the value at the current node for both the tree nodes and compare the left with right and right with left
        return (node1.val == node2.val) and self.helper(node1.left, node2.right) and self.helper(node1.right, node2.left)     

