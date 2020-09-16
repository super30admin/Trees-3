// Time Complexity : O(V+E)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution:
     def isSymmetric(self, root: TreeNode) -> bool:
        return self.isMirror(root,root)
     def isMirror(self,roota,rootb):
        if roota==None and rootb==None: #if both same, return true
            return True
        if roota==None or rootb==None: #if one of them is None, false
            return False
        #compare between subtreeA left, subtreeB right and vice versa.
        return roota.val==rootb.val and self.isMirror(roota.left,rootb.right) and self.isMirror(rootb.left,roota.right) 

        
            
            