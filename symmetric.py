class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        '''
        Time complexity : O(logn)
        Space Complexity : O(logn)
        
        '''
        
        '''
        Recursive approch
        def isMirror(t1,t2):
            if t1 == None and t2 == None: return True
            if t1 == None or t2 == None: return False
            return (t1.val == t2.val) and isMirror(t1.right,t2.left) and isMirror(t1.left,t2.right)
        return isMirror(root,root) 
        '''
        
        '''
        iterative approch
        '''
        q = []
        q.append(root)
        q.append(root)
        while q:
            t1 = q.pop()
            t2 = q.pop()
            if t1 == None and t2 == None: continue
            if t1 == None or t2 == None: return False
            if t1.val != t2.val: return False
            q.append(t1.right)
            q.append(t2.left)
            q.append(t1.left)
            q.append(t2.right)
        return True
    

            
        
        