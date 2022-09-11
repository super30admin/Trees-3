#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        ans = [] #Store result here
        def helper(curr,node,add):
            nonlocal ans
            
            if node.right == None and node.left == None and add == targetSum: #If the node is a root node and if the target is met add it to ans and return it before state
                ans.append(curr)
                return
            if node.left != None: #Add left node to the temp paramter
                helper(curr+[node.left.val],node.left,add+node.left.val)
            if node.right != None: #Add right node to the temp paramter
                helper(curr+[node.right.val],node.right,add+node.right.val)
        if root == None:
            return []
        helper([root.val],root,root.val)
        return ans