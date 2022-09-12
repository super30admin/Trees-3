'''
101. Symmetric Tree

APPROACH 1: inorder and inorder reverse result list comparison 
TIME COMPLEXITY: O(h)
SPACE COMPLEXITY: O(N)
LEETCODE: Yes
DIFFICULTY: No

APPROACH 1: inorder and inorder reverse intermediate stack comparison
TIME COMPLEXITY: O(n)
SPACE COMPLEXITY: O(h)
LEETCODE: Yes
DIFFICULTY: A bit, but could solve it

'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        from collections import deque
        
        def approach1():
            global l1, l2
            l1, l2 = [], []
            
            
            if root.left == None and root.right == None:
                return True
            elif root.left == None or root.right == None:
                return False
            
            def pre_order(root):
                global l1
                # base 
                if root.left == None and root.right == None:
                    l1.append(root.val)
                    return
                
                # logic
                l1.append(root.val)
                if root.left != None:
                    pre_order(root.left)
                else:
                    l1.append(None)
                if root.right != None:
                    pre_order(root.right)
                else:
                    l1.append(None)
                
                
            
            def pre_order_reverse(root):
                global l2
                # base 
                if root.left == None and root.right == None:
                    l2.append(root.val)
                    return
                
                # logic
                l2.append(root.val)
                if root.right != None:
                    pre_order_reverse(root.right)
                else:
                    l2.append(None)
                if root.left != None:
                    pre_order_reverse(root.left)
                else:
                    l2.append(None)
                
            
            pre_order(root.left)
            pre_order_reverse(root.right)
            
            print(l1, l2)
            if l1 == l2:
                return True
            else:
                return False
        
        
        def approach2(root):
            def inorder(rt):
                global lst, rst
                while rt != None:
                    lst.append(rt)
                    rt = rt.left
            
            def inorder_reverse(rt):
                global lst, rst
                while rt != None:
                    rst.append(rt)
                    rt = rt.right
            
            global lst, rst
            lst, rst = deque(), deque()
            inorder(root.left)
            inorder_reverse(root.right)
            
            while len(lst) == len(rst) and len(lst) > 0:
                lnode = lst.pop()
                rnode = rst.pop()
                
                if lnode.val != rnode.val:
                    return False
                inorder(lnode.right)
                inorder_reverse(rnode.left)
                
            if len(lst) == len(rst) == 0:
                return True
            else:
                return False
        
        
        return approach2(root)
        # return approach1()
