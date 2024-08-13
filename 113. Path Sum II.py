# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : Average : O(height)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - Recursively add nodes traversing in dfs, also calculating sum
    - when leaf node reached, then compare to target sum
    - pop out from the list, as lists are reference and will carry data afterwards as well
    '''
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        finalList = []
        def findsum(node, currentSum, lst = []):
            nonlocal finalList
            if node == None:
                return
            currentSum += node.val
            lst.append(node.val)
            if node.left == None and node.right == None:
                if currentSum == targetSum:
                    finalList.append(copy.deepcopy(lst))
            
            findsum(node.left, currentSum, lst)
            findsum(node.right, currentSum, lst)
            lst.pop()
        
        findsum(root, 0)
        return finalList
        