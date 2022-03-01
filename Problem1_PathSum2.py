#Time Complexity: O(n)
#Space Complexity: O(m) Recursion Stack
#LeetCode: Yes

class Node:
    def __init__(self, data):
        self.val = data
        self.left = None
        self.right = None
    

class Solution:
    def pathSum(self, root, targetSum):
        result = []
        target = targetSum

        def helper(root, curSum, path):
            #base case
            if root == None:
                return
            
            #Condition for every Node
            curSum += root.val
            path.append(root.val)

            #Leaf Node condition
            if root.left == None and root.right == None:
                if curSum == target:
                    result.append(path)


            #logic 
            helper(root.left, curSum, path.copy())
            helper(root.right, curSum, path.copy())
        
        helper(root, 0, [])
        return result


if __name__ == "__main__":
    obj = Solution()
    root = Node(5)
    root.left = Node(4)
    root.right = Node(8)
    root.left.left = Node(4)
    print(obj.pathSum(root, 13))

