# TC: O(N^2) since we traverse all the nodes of the trees and copy the path elements for each valid path. 
# SC: O(N) since we are returning the copied lists of valid paths into final list and just the only extra space we use is the list to store the path at every node. 

class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        
        self.path = []
        def inorder_trav(root, currSum, currPath):
            if not root:
                return
            
            currPath.append(root.val)
            
            currSum += root.val
            
            if not root.left and not root.right and currSum == targetSum:
                new_list = []
                new_list = currPath.copy()
                self.path.append(new_list)
                
            inorder_trav(root.left, currSum, currPath)
            inorder_trav(root.right, currSum, currPath)
            
            currPath.pop()
            
        
        inorder_trav(root, 0, [])
        return self.path
        
