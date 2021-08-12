#leetcode solution accepted
# Time complexity: O(nlogn) but worst case scenairo can go upto O(n^2)
#space complexity: O(nlogn) 




class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfs(node, sm): #node is the current node, sm = targetsum
            if not node: return []
            if not node.left and not node.right and sm == node.val:
                return [[node.val]] #Check if we reached leaf, and value in this leaf is equal to node.val, in this case return [[node.val]
           #un function recursively for left and right children. Not that some of them can be empty, in thic case answer for this child will be [].
            lft = dfs(node.left, sm - node.val)
            rgh = dfs(node.right, sm - node.val)
            return [cand + [node.val] for cand in lft + rgh]
            
        return [s[::-1] for s in dfs(root, targetSum)]