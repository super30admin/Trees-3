# Time Complexity : O(n*n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Your code here along with comments explaining your approach
# create a list and add root node to it.Check if the list is palindrome and if yes, 
# find the current length of list and for those many nodes in the list from start, add their children by popping them out
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def ispalindrome(li):
            s = 0
            e = len(li)-1
            while s<=e:
                if li[s]==None and li[e]==None:
                    print("both are none")
                    s+=1
                    e-=1
                elif li[s] and li[e]:
                    print("checking values")
                    if li[s].val!=li[e].val:
                        print("not equal")
                        return False
                    s+=1
                    e-=1
                else:
                    print("both are not equal")
                    return False
            return True
        li = [root]
        while li !=[]:
            if ispalindrome(li):
                l = len(li)
                for i in range(l):
                    m = li.pop(0)
                    if m: 
                        li.append(m.left)
                        li.append(m.right)
            else:
                return False
        return True