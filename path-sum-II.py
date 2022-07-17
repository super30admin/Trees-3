"""
Runtime Complexity:
O(n^2) - because we traverse n nodes and create a list of path which contains 'n' nodes and we copy/append the path to our main list of lists.
Space Complexity:
O(n)- path list contains 'n' nodes. 
Yes, the code worked on leetcode.

"""
class Solution:
    
    
    def dfs(self,root,targetSum,path,path_list):
        if not root:
            return
        path.append(root.val)
        
        if targetSum==root.val and not root.left and not root.right:
            path_list.append(list(path))
        else:
            self.dfs(root.left,targetSum-root.val,path,path_list)
            self.dfs(root.right,targetSum-root.val,path,path_list)
        path.pop()
        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        path_list = []
        self.dfs(root,targetSum,[],path_list)
        return path_list


###


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        path = []
        curr = []
        
        def dfs(root,currSum):
            if root:
                curr.append(root.val)
                currSum+=root.val
                if not root.left and not root.right:
                    if currSum==targetSum:
                        path.append(curr.copy())
                else:
                    dfs(root.left,currSum)
                    dfs(root.right,currSum)
                curr.pop()
        dfs(root,0)
        return path
                    
        