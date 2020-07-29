#Time Complexity: O(n)
#Space Complexity: O(h) where h is the height of the tree
#Works on leetcode: yes
#Approach: We use a helper function to recurse, as we have to check all paths from root to leaf. When we get a leaf node and 
#it's value is equal to remaining sum, we add the value to current path list and add this list to result. Otherwise whenever
#we find root.left and root.right, we call the helper and decrement the sum by root.val and add root.val to current list.  
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if not root:
            return []
        res = []
        self.helper(root, sum, [], res)
        return res
    
    def helper(self, root, sum, ls, res):
        if not root.left and not root.right and root.val==sum:
            ls.append(root.val)
            res.append(ls)
        if root.left:
            self.helper(root.left, sum-root.val, ls+[root.val], res)
        if root.right:
            self.helper(root.right, sum-root.val, ls+[root.val], res)
        