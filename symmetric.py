# Time Complexity :O(N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach




from collections import deque
class Solution:

    def alternate_solution(self, root):
        q=deque([])
        q.append(root)

        while(len(q)):
            l=0
            size=len(q)
            r=len(q)-1
            # print(q)
            while(l<r):
                if(q[l]==None and q[r]==None):
                    l+=1
                    r-=1
                    continue
                if(q[l]==None or q[r]==None):
                    return False
                if(q[l].val!=q[r].val):
                    return False
                l+=1
                r-=1
            while(size):
                curr=q.popleft()
                if(curr):
                    q.append(curr.left)
                    q.append(curr.right)
                size-=1

        return True

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q=deque([])
        q.append(root.left)
        q.append(root.right)

        while(len(q)):
            l=q.popleft()
            r=q.popleft()
            if(l==None and r==None):
                continue
            if(l==None or r==None):
                return False
            if(l.val!=r.val):
                return False
            q.append(l.left)
            q.append(r.right)
            q.append(l.right)
            q.append(r.left)
        return True
