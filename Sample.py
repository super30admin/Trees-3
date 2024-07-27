#######113. Path Sum II#################################################################################################################
// Time Complexity : n
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
Following approach is the backtracking approach where I have taken l1 is intermediate list and result as final list, we keep appending nodes to l1 and if any result doesn't match with target we backtrack and remove the element


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.res = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        l1=[]
        self.inOrder(root, targetSum, 0,l1)
        return self.res

    def inOrder(self,root,targetSum,currSum,l1):
        #base
        if root is None:
            print('base in none')
            return
        
        
        #currSum
        currSum+=root.val
        l1.append(root.val)
        #l2=copy.deepcopy(l1)
        #l2.append(root.val)
        if root.left is None and root.right is None and targetSum==currSum:
            print('base in append')
            #print(l1)
            l2=copy.deepcopy(l1)
            #print(hex(id(l2)))
            self.res.append(l2)
            #print(self.res)
            #return
        
        #print('1st call:',root.left,targetSum, currSum,l1)
        self.inOrder(root.left, targetSum, currSum,l1)
        #print('2nd call:',root.right, targetSum, currSum,l1)
        self.inOrder(root.right, targetSum, currSum,l1)
        l1.pop()
        #print('recursion completed: ',self.res)

        
        
        

######101. Symmetric Tree##################################################################################################################


// Time Complexity : n
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA

// Your code here along with comments explaining your approach in three sentences only
We have used a BFS approach here, where when we reach to level 2, we take left child of left and right child of right and before inserting we compare, if it fails than return false or else we put it and than for l=next level we compare other childs



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q1=collections.deque()
        #left,right=None,None
        q1.append(root)
        while len(q1)>0:
            len1=len(q1)
            #print(q1,len1)
            if len1==1:
                curr=q1.popleft()
                if (curr.left and curr.right is None) or (curr.left is None and curr.right):
                    return False
                else:
                    if curr.left:
                        q1.append(curr.left)
                    if curr.right:
                        q1.append(curr.right)
            else:
                i=0
                while i < len1:
                    #print(i)
                    currleft=q1.popleft()
                    currright=q1.popleft()
                    i+=2
                    if currleft.val!=currright.val:
                        return False
                    else:
                        if (currleft.left and currright.right is None) or (currleft.left is None and currright.right):
                            return False
                        else:
                            if currleft.left:
                                q1.append(currleft.left)
                            if currright.right:
                                q1.append(currright.right)

                        if (currleft.right and currright.left is None) or (currleft.right is None and currright.left):
                            return False    
                        else:
                            if currleft.right:
                                q1.append(currleft.right)
                            if currright.left:
                                q1.append(currright.left)
        return True

        

