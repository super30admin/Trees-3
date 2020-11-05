"""
Time complexity is  O(N)
Space complexity is O(N) (Stack)

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_symmetric_iter:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        
        st=[]
        st.append(root)
        st.append(root)
        
        while(st):
            left=st.pop()
            right=st.pop()
            
            if left is None and right is None:
                continue
            
            if left is None or right is None or left.val!=right.val :
                return False
            
            #if left.val!=right.val:
                #return False
            
            st.append(left.left)
            st.append(right.right)
            st.append(left.right)
            st.append(right.left)
            
        return True
   
    
    
    