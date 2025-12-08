# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)
* Method 1 - If currSum==targetSum at leaf Node We will record that path in our answer. Here every node is having a new list. T- O(n*h), S-O(n*h)
* Method 2 - Backtrack, reverse the action, remove the element that was added to the path -> path.remove(path.size()-1); . T- O(n*h), S-O(n) No need of maintaining new list everytime.
* Make sure you keep copy of path in the result as at the end everything will get removed.


## Problem2 (https://leetcode.com/problems/symmetric-tree/)
* when leftside && rightside both are same then it is symmetric
* checking null conditions properly

