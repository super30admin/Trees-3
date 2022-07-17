# Time complexity: O(n)
# Space complexity: O(n)
# Approach: DFS
# left's left should be equal to right's right
# left's right should be equal to right's left.



class Solution:
    global validtree
    #validtree = True
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        global validtree
        validtree = True
        self.helper(root.left,root.right)
        return validtree
    def helper(self, left, right):
        global validtree
        #base
        if left== None and right == None:
            return
        if(left == None or right == None or left.val != right.val):
            validtree = False
            return
        #recursion:
        self.helper(left.left, right.right)
        self.helper(left.right, right.left)
        