// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func isSymmetric(_ root: TreeNode?) -> Bool {
        guard let root = root else { return true }
        return isSymmetricHelper(root.left,root.right)
    }
    func isSymmetricHelper(_ n1: TreeNode?, _ n2: TreeNode?) -> Bool {
        if n1 == nil && n2 == nil {
            return true
        }
        if n1 == nil || n2 == nil || n1?.val != n2?.val {
            return false
        }
        return isSymmetricHelper(n1?.left,n2?.right) && isSymmetricHelper(n1?.right,n2?.left)
    }