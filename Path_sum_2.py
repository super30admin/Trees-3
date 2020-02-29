Recursive solution:
// Time Complexity : O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach:
In this recursive solution we traverse from root to the leaf and at each node we keep a track of the nodes visited from the root in a list.when the traverse reaches the leaf node then we check if the sum of the list is equal to the target sum given.If yes we store the entire path from root to the leaf.


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.out=[]
        self.list1=[]
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        sum3=0
        if root==None:
            return []
        return self.sum1(root,sum3,sum)
    
    def sum1(self,root,sum3,target):
        if root==None :
            return 
        sum3=sum3+root.val
        self.list1.append(root.val)
        if sum3==target and root.left==None and root.right==None:
            self.out.append(self.list1[:])
        self.sum1(root.left,sum3,target)
        self.sum1(root.right,sum3,target)
        self.list1.pop()
        return self.out
        
        
Iterative BFS solution:

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None 


// Your code here along with comments explaining your approach
we use BFS traversal in this problem and used queue as the data structure.At every level we store all the elements in the queue and pop them one by one.we do this till we reach the leaf nodes.for every node we are also keeping a track of path from root along with its sum from the root and if the sum is equal to the target then we store the path.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        out=[]
        if root == None:
            return []
        d = deque([[root,root.val, [root.val]]])
        while len(d) > 0:
            s = d.popleft()
            node = s[0]
            currvalue=s[1]
            value = s[2]
            if node.left == None and node.right == None and currvalue== sum:
                out.append(list(value))
            if node.left != None:
                new = list(value)
                new.append(node.left.val)
                d.append([node.left,currvalue+node.left.val,new ])
            if node.right != None:
                new = list(value)
                new.append(node.right.val)
                d.append([node.right,currvalue+node.right.val,new])
        return out
        
            