# // Time Complexity : O(n^2)
# // Space Complexity : O(n^2)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def pathSum(self, root, targetSum):
        
        self.output = []
        
        def dfs(node, path, sm):
            sm+= node.val
            tmp = path+[node.val]
            
            # calculate left path
            if node.left:
                dfs(node.left,tmp,sm)
            
            # calculate right path
            if node.right:
                dfs(node.right, tmp,sm)
                
            # if sum matches append the path to output
            if not node.left and not node.right and sm == targetSum:
                self.output.append(tmp)
        
        #  edge case
        if not root: return []
        dfs(root,[],0)
        return self.output