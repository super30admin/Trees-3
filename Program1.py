#Time complexity is: O(n)
#Space complexity is: O(h) where h is the height of the tree
#Program ran successfully on leetcode
#No issues faced while coding

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        #creating an empty final list to be returned as final output
        self.final_list=[]
        self.helper(root,targetSum,0,[])
        return self.final_list

    def helper(self,root,targetSum,sum_val,internal_list):
        #If the root is Null, we will return nothing
        if(root==None):
            return
        #Adding the root value to the local sum_val
        sum_val+=root.val
        #appending the root value to the internal list
        internal_list.append(root.val)
        #checking whether the root is leaf node or not
        if(root.left==None and root.right==None):
            #if the sum value is equal to target value, we will append the array tot he final list
            if(sum_val==targetSum):
                self.final_list.append(list(internal_list))
        #Moving towards left side of the tree
        self.helper(root.left,targetSum,sum_val,internal_list)
        #Moving towards right side of the tree
        self.helper(root.right,targetSum,sum_val,internal_list)
        #Backtracking the list
        internal_list.pop()