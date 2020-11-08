class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:

        s=[]
        s.append(root)
        s.append(root)

        while s:
            t1 = s.pop()
            t2 = s.pop()

            if t1 is None and t2 is None:
                continue
            if t1 is None or t2 is None:
                return False
            if t1.val!= t2.val:
                return False

            s.append(t1.left)
            s.append(t2.right)
            s.append(t1.right)
            s.append(t2.left)

        return True

#recursive
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:

        def isMirror(t1,t2):
            #base case
            if t1 is None and t2 is None:
                return True
            if t1 is None or t2 is None:
                return False
            return t1.val==t2.val and isMirror(t1.left,t2.right) and isMirror(t1.right,t2.left)

        return isMirror(root,root)
