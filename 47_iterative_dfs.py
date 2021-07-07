class Solution:
    def isSymmetric(self, root) :
        if not(root):
            return True
        lst_stk =[]
        lst_stk.append(root.left)
        lst_stk.append(root.right)
        while lst_stk:
            right = lst_stk.pop()
            left = lst_stk.pop()
            if not(right) and not(left):
                continue
            if not(right) or not(left) or left.val != right.val:
                return False
            lst_stk.append(left.left)
            lst_stk.append(right.right)
            lst_stk.append(left.right)
            lst_stk.append(right.left)
        return True