// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    var output = [[Int]]()
    func pathSum(_ root: TreeNode?, _ targetSum: Int) -> [[Int]] {
        var array = [Int]()
        pathSumHelper(root,0,targetSum,&array)
        return output
    }
    func pathSumHelper(_ root: TreeNode?, _ sum: Int, _ targetSum: Int, _  array: inout [Int]) {
        guard let root = root else { return }
        var sum = sum
        sum += root.val
        array.append(root.val)
        if root.left == nil && root.right == nil {
            if sum == targetSum {
                output.append(array)
            }
        }
        pathSumHelper(root.left,sum,targetSum,&array)
        pathSumHelper(root.right,sum,targetSum,&array)
        array.removeLast() 
    }