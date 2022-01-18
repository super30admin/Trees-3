
# //Recursive Approach
# // Time Complexity : O(H)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
# // Your code here along with comments explaining your approach
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        if root == None:
            return True
        
        return self.helper(root.left, root.right)
    
    def helper(self, left, right) -> bool:
        if left == None and right == None:
            return True
        if left != None and right == None:
            return False
        if left == None and right != None:
            return False
        if left.val != right.val:
            return False
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)
    


# //Iterative Approach
# // Time Complexity : O(H)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        if root == None:
            return True
        st = list()
        st.append(root.left)
        st.append(root.right)
        
        while st != []:
            right = st.pop()
            left = st.pop()
            
            if left == None and right == None:
                continue
            if left != None and right == None:
                return False
            if left == None and right != None:
                return False
            if left.val != right.val:
                return False
        
            st.append(left.left)
            st.append(right.right)
            
            st.append(left.right)
            st.append(right.left)
        
        return True
        
        
    
        
        


        
        
        
    
        