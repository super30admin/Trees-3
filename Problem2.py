# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Symmetric Tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        #--------recusion----dfs----
        self.flag = True
        self.helper(root.left, root.right)
        return self.flag

    def helper(self, left:Optional[TreeNode], right: Optional[TreeNode]):
        if left == None and right == None:
            return
        if left == None or right == None:
            self.flag = False
            return
        if left.val != right.val:
            self.flag = False
            return
        
        if self.flag:
            self.helper(left.left, right.right)
        if self.flag:
            self.helper(left.right, right.left)


        # -------bfs-------
        # q = [root]

        # while q:
        #     size = len(q)
        #     lst = []
        #     for i in range(size):
        #         curr = q.pop(0)
        #         lst.append(curr)
        #         if curr != None:
        #             q.append(curr.left)
        #             q.append(curr.right)
        #     print(lst)
        #     left = 0
        #     right =len(lst) - 1

        #     while left < right:
        #         if lst[left] == None and lst[right] == None:
        #             left += 1
        #             right -= 1
        #             continue
        #         elif lst[left] == None or lst[right] == None:
        #             return False
        #         elif lst[left].val != lst[right].val:
        #             return False
        #         else:
        #             left += 1
        #             right -= 1
        # return True


                

        