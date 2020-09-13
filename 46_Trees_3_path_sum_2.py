#Time Complexity : O(n^2) where n is the number of elements
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 
#Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def helper(root,sum,temp_list,ans_list):
            if not root:
                return 
            temp_list.append(root.val)
            if not root.left and not root.right and root.val==sum:
                    ans_list.append(list(temp_list)) #Why using list method? call by reference, when we are just appending normal value, it would be popped out from ans_list as well when we are popping the same from temp_list, Python beacuse of it got added by reference. Python trick. So make a copy and add then, that's is why using list()
            else:
                helper(root.left,sum-root.val,temp_list,ans_list)
                helper(root.right,sum-root.val,temp_list,ans_list)
            temp_list.pop()
        temp_list=[]
        ans_list=[]
        helper(root,sum,temp_list,ans_list)
        return ans_list
                    
                    