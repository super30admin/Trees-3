#Time Complexity : O(N), N being the number of values in tree. 
#Space Complexity : O(h), h being the height of the tree, or O(logN).
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Fiddled with deepcopy for a bit before
#trying out the solution. 

#Your code here along with comments explaining your approach in three sentences only
'''Recursively call the tree and the left and right nodes, and add the node values to 
the array and the value to the current. If current is the target sum, deepcopy the 
array into result. After calling left and right nodes, backtrack by popping the last
value from the array. 
'''
class Solution:
    def __init__(self):
        self.result = []
    def helper(self, node, array, currSum, targetSum):
        if node==None:
            return 
        else:
            if node.left==None and node.right==None:
                array.append(node.val)
                currSum=currSum+node.val
                if currSum ==targetSum:
                    temp = copy.deepcopy(array)
                    self.result.append(temp)
                array.pop(len(array)-1)
                
            array.append(node.val)
            currSum=currSum+node.val
            self.helper(node.left, array, currSum, targetSum)
            self.helper(node.right, array, currSum, targetSum)
            array.pop(len(array)-1)

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.helper(root, [], 0, targetSum)
        return self.result