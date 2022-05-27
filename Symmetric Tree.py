# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity: O(n2)
#Space Complexity: O(n)
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        q = deque()
        q.append(root)
        while q:
            length = len(q)
            lst = []
            for i in range(length):
                el = q.popleft()
                if el == None:
                    lst.append(None)
                else:
                    lst.append(el.val)
                if el:
                    # if el.left== None and el.right==None:
                    #     continue     
                    q.append(el.left)
                    q.append(el.right)
            print(lst)
            if not self.palindrome(lst):
                return False
        return True
            
    def palindrome(self,lst):
        return lst == lst[::-1]
                    