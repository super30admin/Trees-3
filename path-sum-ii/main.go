package main

import "fmt"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

// Time : O(n): n is height of the tree and worst case it's a skewed tree
// Space : O(1) : just allocating two arrays in between to copy the elements and that too will be garbage collected later.

func pathSum(root *TreeNode, targetSum int) [][]int {
	var helper func(root *TreeNode, path []int, sum, targetSum int)
	var result [][]int
	helper = func(root *TreeNode, path []int, sum, targetSum int) {
		//base
		if root == nil {
			return
		}
		//logic
		sum = sum + root.Val
		path = append(path, root.Val)
		if root.Left == nil && root.Right == nil { // means I am at leaf node
			if sum == targetSum {
				// pass by ref and pass by value bs
				// need to allocate a new array and cpy the elements becasue under the hood golang removes the last element by then when adding a new element it basically uses the same memory address
				r := make([]int, len(path))
				copy(r, path)
				result = append(result, r)
			}
			fmt.Println(result)
		}
		//left
		helper(root.Left, path, sum, targetSum)
		//right
		helper(root.Right, path, sum, targetSum)

		// before returning remove the current node's value
		fmt.Println(path)
		path = path[:len(path)-1]

		return
	}
	helper(root, []int{}, 0, targetSum)
	return result
}
