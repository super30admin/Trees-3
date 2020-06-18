# Time Complexity : O(n) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Node:
    def __init__(self,x):
        self.val = x 
        self.left = None 
        self.right = None 

class Solution:
    # 1) Recursive solution: Time = O(n) | O(n) space
    # def isSymmetric(self,root):
    #     if not root:
    #         return True 
    #     return self.helper(root.left,root.right)
    # def helper(self,left,right):
    #     # Base case 
    #     if not left and not right:
    #         return True 
    #     if not left or not right or left.val != right.val:
    #         return False
        
    #     # Logic 
    #     return self.helper(left.left,right.right) and self.helper(left.right,right.left)
    
    # Iterative : Time = O(n) | O(n) space
    def isSymmetric(self,root):
        if not root:
            return True 
        stack = []
        stack.append(root.left)
        stack.append(root.right)
        while stack:
            right = stack.pop()
            left = stack.pop()
            if not left and not right:
                continue 
            if not right or not left or left.val != right.val:
                return False 
            stack.append(left.left)
            stack.append(right.right)
            stack.append(left.right)
            stack.append(right.left)
        return True
        

if __name__ == "__main__":
    s = Solution()
    n = Node(1)
    n.left = Node(2)
    n.right = Node(2)
    n.left.left = Node(3)
    n.left.right = Node(4)
    n.right.left = Node(4)
    n.right.right = Node(3)
    
    # n = Node(1)
    # n.left = Node(2)
    # n.right = Node(2)
    # n.left.right = Node(3)
    # n.right.right = Node(3)
    res = s.isSymmetric(n)
    print(res)