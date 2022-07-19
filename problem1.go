
// Time Complexity : O(N)
// Space Complexity : O(H) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var result [][]int

func pathSum(root *TreeNode, targetSum int) [][]int {
    if root == nil{
        return [][]int{}
    }
    
    result = [][]int{}
    
    helper(root,[]int{},0,targetSum)
    
    return result
}


func helper(root *TreeNode,path []int,sum,targetSum int){
    if root == nil{
        return
    }
    
    sum += root.Val
    path = append(path,root.Val)
    
    if root.Left == nil && root.Right == nil && sum == targetSum{
        res := []int{}
        res = append(res,path...)
        result = append(result,res)
    } 
    
    helper(root.Left,path,sum,targetSum)
    helper(root.Right,path,sum,targetSum)
    
    path = path[:len(path)-1]
}
