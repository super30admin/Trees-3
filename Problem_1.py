"""
Time Complexity : O(n) 
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
We did this question first with normal recursion and then with backtraking. I have commented the recursive
solution here. For this question, iitially we traverse through all the nodes till the leaf node and keep
on adding the root value. When we reach leaf node, if current sum equals the target sum, we append the path to
the result which is global. In case of pure recursive solution, we keep a copy of path at every point.
This solution takes extra space. So, in backtracking, we just maintain a single list and pass that
everytime instead of passing a copy everytime. Backtracking consists of 3 parts, action,recurse and backtrack.
In action, we make a deepcopy of the array that we are adding to the result. If we donot do that, the list
added to the result would be just a mere reference, and at the end we would get just empty lists in the
result. In backtrack part, we keep on removing the last element that we added.
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution(object):
    def pathSum(self, root, sum):
        global result
        result = []
        if not root:
            return []
        self.helper(root, 0, sum, [])
        return result

    def helper(self, root, tempsum, sum, temparr):
        global result
        if not root:
            return
        rootval = root.val
        currsum = tempsum+rootval
        temparr.append(rootval)
        # action
        if not root.left and not root.right:
            if currsum == sum:
                arr = copy.deepcopy(temparr)
                result.append(arr)
        # recurse
        self.helper(root.left, currsum, sum, temparr)
        self.helper(root.right, currsum, sum, temparr)
        # backtrack
        temparr.pop()

    # def helper(self,root,tempsum,sum,temparr):
    #     global result
    #     if not root:
    #         return
    #     rootval=root.val
    #     currsum=tempsum+rootval
    #     if not root.left and not root.right:
    #         if currsum==sum:
    #             result.append(temparr+[rootval])
    #     self.helper(root.left,currsum,sum,temparr+[rootval])
    #     self.helper(root.right,currsum,sum,temparr+[rootval])
