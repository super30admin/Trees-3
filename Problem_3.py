# Runs on Leetcode

Bruteforce - 
  # Runtime - O(n)
  # Memory - O(n)
  
Optimized - 
  # Runtime - O()
  # Memory - O()

'''
BRUTEFORCE

1) pushing all nodes to queue level wise and checking if the node values are symmetric or not using a temp list. 
2) If all temp lists of the tree are palindrome, then the tree is symmetric.

OPTIMIZED


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
