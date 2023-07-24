#Time:O(n)
#Space:O(n**2)
class Solution:
    def __init__(self):
        self.ans_list = []
        
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        
        def helper(root,list_ref,sum_val):
            print(sum_val,list_ref)
            if sum_val == targetSum and not root.left and not root.right:
                print(list_ref)
                self.ans_list.append(list_ref)
                return
            if not root:
                return
            if root.left:
                helper(root.left,list_ref + [root.left.val],sum_val+root.left.val)
            if root.right:
                helper(root.right,list_ref+ [root.right.val],sum_val+root.right.val)
        if root:
            helper(root,[root.val],root.val)
        return self.ans_list