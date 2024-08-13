# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : Average : O(height)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - for a symmetric tree the left node of left side should be equal to right node of right side
    - and vice versa. using this approach we recursively test for each nodes
    '''
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def helper(node1, node2):
            if node1 == None and node2 == None:
                return True
            elif node1 == None or node2 == None:
                return False
            return (node1.val == node2.val) and helper(node1.left, node2.right) and helper(node1.right, node2.left)
        
        return helper(root, root)
        