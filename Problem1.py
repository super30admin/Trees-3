# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # tc : O(n) visiting each node once + O(h) to create a deep copy for valid pairs,  -> O(n)
    # sc : O(h) the recrussive stack space, O(h) for the path  -> O(h)
    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """
        # approach : calcualet sum of each path and verify if the sum is equal to the targetsum if euqal adding that path into the output out_arr
        # to calculate for each path, i will use recrussion in a recrussive way i will add the currnet node value and also add this node in a path []
        # if the root left and right are none that meand we have reached end of a path, if the sum is equal then i will add this path nodes into the out arr if not will skip it 
        # after once we move from the left path to the right path we need to pop up the left elemnt lets say we are at 11 position in the given tree
        # once we move to the left tree the path will have [5,4,11,7] and when we go back to the 11th position the path shoudl not have 7 in it
        # so we need pop up the path variable once we have checked left and right , we are done with this node so the last node in the path need to be poped up 
        # in storing the path in the out_arr, we know that data sturcture of a dasts structure is a pointer so if we directly add the path in the putput arr, when we return it points to the path address which is modified 
        # by the end of the recurssion so the path will be last path which is wrong, so to avoid this issue will create a deep copy, while appending into the out_arr


        self.out_arr = []
        self.helper(root,targetSum,0,[])

        return self.out_arr

    def helper(self, root, targetSum, curr, path):
        if root is None:
            return

        path.append(root.val)
        curr += root.val

        if root.left is None and root.right is None and curr == targetSum:
            self.out_arr.append(list(path))

        self.helper(root.left,targetSum,curr, path)
        self.helper(root.right, targetSum, curr, path)

        path.pop()

