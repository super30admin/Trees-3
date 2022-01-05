# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time: O(n)
# Space: O(n) recursive stack
class Solution(object):
    def __init__(self):
        self.ans = []
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        self.rec(root, 0, targetSum, [])
        return self.ans
    def rec(self, root, sm, target, arr):
        if root == None:
            return
        arr.append(root.val)
        #print(sm+root.val)
        if root.left == None and root.right == None:
            if sm+root.val == target:
                #print(arr)
                self.ans.append(list(arr))
                arr.pop()
                return
            
        if root.left != None:
            self.rec(root.left, sm+root.val, target, (arr))
        if root.right != None:
            self.rec(root.right, sm+root.val, target, (arr))
        arr.pop()
        
        
