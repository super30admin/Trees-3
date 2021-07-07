
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class Solution:

    # RECURSIVE SOLUTION
    # time : O(N)
    # space : O(H) + Recursive Call Stack 

    def pathSum2(self, root, target):
        self.result = []
        self.helper(root, target, [], 0)
        return self.result

    def helper(self, root, target, temp, value):

        # BASE CASE
        if root == None:
            return                  
        if root.left == None and root.right == None and value+root.val == target:  
            self.result.append(temp + [root.val])       ########## temp.append(root.val) ---> ERROR
            return             
            
        # LOGIC
                                ########## temp.append(root.val) ---> ERROR 
        self.helper(root.left, target, temp + [root.val], value+root.val)
        self.helper(root.right, target, temp + [root.val], value+root.val)



    # ============================================================================================================

    # ITERATIVE SOLUTION
    # time : O(N)
    # space : O(H) 

    def pathSum2(self, root, target):
        if root == None:
            return []

        result = []
        stack = [(root, [root.val])]       # stack holds the current_Node, current_List

        while stack != []:
            node, lst = stack.pop()        # pop() --> O(1) to pop the last element of a Python list, and O(N) to pop an arbitrary element (since the whole rest of the list has to be shifted).
                                                    
            if node.left == None and node.right == None:
                summ = 0
                for num in lst:            # sum(list) method --> O(N)
                    summ += num
                if summ == target:
                    result.append(lst)

            if node.left:
                stack.append((node.left, lst + [node.left.val]))
            if node.right:
                stack.append((node.right, lst + [node.right.val]))

        return result
            



a = TreeNode(20)
a.left = TreeNode(15)
a.right = TreeNode(25)
a.left.left = TreeNode(13)
a.left.right = TreeNode(18)
a.right.left = TreeNode(24)
a.right.right = TreeNode(27)
a.left.left.left = TreeNode(10)
a.left.left.right = TreeNode(14)
a.left.right.left = TreeNode(16)
a.left.right.right = TreeNode(19)

obj = Solution()
print(obj.pathSum2(root = a, target=72))
