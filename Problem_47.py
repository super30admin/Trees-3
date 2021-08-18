class Solution(object):
    def pathSum(self, root, sum):
      
        if not root: return []
        cur = []
        res = []
        def preorder(root, sum):
            cur.append(root.val)
            if not root.left and not root.right and sum == root.val:
                res.append(cur[:])
            if root.left: preorder(root.left, sum - root.val)
            if root.right: preorder(root.right, sum - root.val)
            cur.pop()
        preorder(root, sum)
        return res

%TC : O(n)
%SC : O(n)