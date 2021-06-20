'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 113. Path Sum II
# You are given the root of a binary tree containing digits from 0 to 9 only.

# Each root-to-leaf path in the tree represents a number.

# For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
# Return the total sum of all root-to-leaf numbers. Test cases are generated so 
# that the answer will fit in a 32-bit integer.

# A leaf node is a node with no children.

#-----------------
# Time Complexity: 
#-----------------
# O(N): Where N is the number of elements in the tree. Need to visit every element
#       at least once.

#------------------
# Space Complexity: 
#------------------
# O(H): Max size of the stack is equal to the height of the tree. 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  40 ms   (91.34 %ile)
# Space            :  15.7 MB (53.00 %ile)

# This solution seems more elegant, but the first solution works better
# in practice because we are not making spurious look aheads
# with pathSumHelper(left) at root node.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        self.targetSum = targetSum
        self.result = []
        self.pathSumHelper(root,0, [])
        return self.result
        
    def pathSumHelper(self, root: TreeNode, root_to_leaf_sum, traversed_nodes=[]):
        #Base case. Do nothing
        if root is None:
            return 
        else:
            # Add current node value to sum
            root_to_leaf_sum += root.val

            # We are considering current node. Lets add it to the traversed list
            traversed_nodes.append(root.val)
            
            self.pathSumHelper(root.left,\
                                         root_to_leaf_sum,\
                                         traversed_nodes)

            # print(f"AT node:{root.val}, root_to_leaf_sum:{root_to_leaf_sum}, traversed_nodes:{traversed_nodes}")
            if root.left is None and root.right is None:
                # IF our condition is satisfied, nodes traversed so far should
                # be in result
                if root_to_leaf_sum == self.targetSum:
                    #Pass by value so that the list appended to result 
                    # doesn't change during operations
                    self.result.append(list(traversed_nodes))
                    # print(f"    Found pathsum:{root_to_leaf_sum}, root_to_leaf_sum:{root_to_leaf_sum}, traversed_nodes: {traversed_nodes} ")
            
            self.pathSumHelper(root.right, \
                                        root_to_leaf_sum, \
                                        traversed_nodes)  
            
            traversed_nodes.pop()

            # else:
            #     if root.left is not None:
                    
            #         # print(f"    Turning left at:{root.val}, root_to_leaf_sum:{root_to_leaf_sum}, traversed_nodes: {traversed_nodes}")
                    
                    
            #         # We went left and did some things, imagine we had only
            #         # 1 node to the left, we would have to pop the traversed
            #         # nodes list because we will now go up 1 level in recursion
            #         traversed_nodes.pop()
                    
            #     if root.right is not None:
            #         # print(f"    Turning right at:{root.val}, root_to_leaf_sum:{root_to_leaf_sum}, traversed_nodes: {traversed_nodes}")
                    
                    
            #         # We went right and did some things, imagine we had only
            #         # 1 node to the right, we would have to pop the traversed
            #         # nodes list because we will now go up 1 level in recursion
            #         # This removal can be considered backtracking
                    
