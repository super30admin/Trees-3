# Runs on Leetcode

Bruteforce - 
  # Runtime - O(n)
  # Memory - O(n)
  
Optimized - 
  # Runtime - O(n)
  # Memory - O(1)

'''
BRUTEFORCE

1) pushing all nodes to queue level wise and checking if the node values are symmetric or not using a temp list. 
2) If all temp lists of the tree are palindrome, then the tree is symmetric.

OPTIMIZED

1) At each level check if left.left == right.right and left.right == right.left for nodes in each level.

              1
            /   \
           2     2
          / \   / \
         4   5 6   4

2) In the tree above we check the following
    at level 1 - no comparisions
    at level 2 - 2 and 2
    at level 3 - 4 and 4, 5 and 6
    
3) Return false if any condition fails

'''
class Solution:
    def isSymmetric_bruteforce(self, root: TreeNode):
        if not root:
            return True
        
        queue = [root]
        while queue:
            temp = []
            for i in range(0,len(queue)):
                a = queue.pop(0)
                if a is not None:
                    temp.append(a.val)
                    try:
                        if a.left:
                            queue.append(a.left)
                        else:
                            queue.append(ListNode(None))
                        if a.right:
                            queue.append(a.right)
                        else:
                            queue.append(ListNode(None))
                    except AttributeError:
                        continue
            if len(temp) > 1:
                if temp != temp[::-1]:
                    return False
                else:
                    continue
        return True
  
  
  
class Solution:
    def isSymmetric_optimized(self, root: TreeNode):
        if not root:
            return True
        
        return self.helper(root.left,root.right)
        
    def helper(self,left,right):
        if left is None and right is None:
            return True
        if left is None or right is None or left.val != right.val:
            return False
        
        return self.helper(left.left,right.right) and self.helper(left.right,right.left)
