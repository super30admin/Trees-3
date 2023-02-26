#Time Complexity : O(N), N being the number of values in tree. 
#Space Complexity : O(h), h being the height of the tree, or O(logN).
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Tried a more complex base case at first
#before going to the simplier final base case. 

#Your code here along with comments explaining your approach in three sentences only
'''Split the tree in half, then if the left and right are the same, continue with 
the outer and inner nodes recursively.
'''
class Solution:
    def helper(self, left, right):
        #base case.
        if left==None or right==None:
            if left==None and right!=None:
                return False
            elif left!=None and right==None:
                return False
            else:
                return True
        
        else:      
            #compare left and right. If true, go on to compare 
            #inner and outer nodes. 
            result = left.val==right.val
            if result == True:
                outer = self.helper(left.left, right.right)
                inner = self.helper(left.right, right.left)
                return outer and inner
            else:
                return False

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        left = root.left
        right = root.right

        result = self.helper(left, right)
        return result