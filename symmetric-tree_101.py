#Approach: checking left and right nodes and lefts node right value with right nodes left and viceversa
#Recursive
#Time Complexity O(N) for all N nodes
#Space Complexity O(H) height of tree
#It successfully runs on the leetcode


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root.left,root.right)
    
    def helper(self,left,right):
        if left and right:
            if left.val!=right.val: return  False
            return self.helper(left.left,right.right) and self.helper(left.right,right.left)
        else:
            return left==right


#Approach: checking lefts node right value with right nodes left and viceversa
#Iterative with stack
#Time Complexity O(N) for all N nodes
#Space Complexity O(H) height of tree stack in this case
#It successfully runs on the leetcode
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        stack=[]
        if not root: return True
        stack.append((root.left,root.right))
     
        
        while stack:
            left, right = stack.pop()
            if not left and not right: continue
            if not left or not right or left.val != right.val:
                return False
            stack.append((left.left,right.right))
            stack.append((left.right,right.left))
            
        return True