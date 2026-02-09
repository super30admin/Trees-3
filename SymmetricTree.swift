//
//  SymmetricTree.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/23/26.
//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init() { self.val = 0; self.left = nil; self.right = nil; }
 *     public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
 *     public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *     }
 * }
 */

class QueueImplUsingLLWithNull<T> {

    private class LinkedListNode<T> {
        var value: T?
        var next: LinkedListNode<T>?
        init(value: T?) {
            self.value = value
        }
    }

    private var front: LinkedListNode<T>?
    private var rear: LinkedListNode<T>?
    private var count: Int = 0

    func enqueue(_ val: T?) {
        let newNode = LinkedListNode(value: val)
        if(rear == nil) {
            //empty linked List
            rear = newNode
            front = newNode
        } else {
            rear?.next = newNode
            rear = newNode
        }
        count += 1
    }

    func dequeue() -> T? {
        guard let frontNode = front else {
            return nil
        }
        let value = frontNode.value
        front = frontNode.next
        if (front == nil) {
            rear = nil
        }
        count -= 1
        return value
    }

    var size: Int {
        return count
    }

    var isEmpty: Bool {
        return count == 0
    }

    var peek: T? {
        return front?.value
    }
}

//MARK: Symmetric tree using queue
class SymmetricTree {
    func isSymmetric(_ root: TreeNode?) -> Bool {
        guard let root = root else {
            return true
        }
        var queue = QueueImplUsingLLWithNull<TreeNode>()
        queue.enqueue(root.left)
        queue.enqueue(root.right)
        while(!queue.isEmpty) {

            let leftNode = queue.dequeue()
            let rightNode = queue.dequeue()

            if (leftNode == nil && rightNode == nil) {
                continue
            }
            if (leftNode == nil || rightNode == nil || leftNode?.val != rightNode?.val) {
                return false
            }
            queue.enqueue(leftNode?.left)
            queue.enqueue(rightNode?.right)
            queue.enqueue(leftNode?.right)
            queue.enqueue(rightNode?.left)

        }
        return true
    }
}

//MARK: Implement stack using linked list
class StackImp<T> {
    
   final class LinkedListNode<T> {
        var value: T?
        var next: LinkedListNode<T>?
        init(value: T?, next: LinkedListNode<T>?) {
            self.value = value
            self.next = next
        }
    }
        
        var head: LinkedListNode<T>?
        
        func push(_ val: T?) {
            let newNode = LinkedListNode(value: val, next: head)
            head = newNode
        }
        
        @discardableResult
        func pop() -> T? {
            guard let currentHead = head else {
                return nil
            }
            head = currentHead.next
            return currentHead.value
        }
        
        func peek() -> T? {
            return head?.value
        }
        
        func isEmpty() -> Bool {
            return head == nil
        }
        
    }

class SymmetricTreeWithStack {
    func isSymmetric(_ root: TreeNode?) -> Bool {
        guard let root = root else {
            return true
        }
        var stack = StackImp<TreeNode>()
        stack.push(root.left)
        stack.push(root.right)

        while(!stack.isEmpty()) {
            let leftNode = stack.pop()
            let rightNode = stack.pop()
            if (leftNode == nil && rightNode == nil) {
                continue
            }
            if (leftNode == nil || rightNode == nil || leftNode?.val != rightNode?.val) {
                return false
            }
            stack.push(leftNode?.left)
            stack.push(rightNode?.right)
            stack.push(leftNode?.right)
            stack.push(rightNode?.left)
        }
        return true
    }
    
    //MARK: isSymmetric with under the hood stack
    //time complexity - O(n) & space complexity - O(n)
    func isSymmetricUsinfRecursionStack(_ root: TreeNode?) -> Bool {
        return dfsUsingRecursion(root?.left, root?.right)
    }

    
    func dfsUsingRecursion(_ left: TreeNode?, _ right: TreeNode?) -> Bool {

        //Base
        if (left == nil && right == nil) {
            return true
        }
        //Logic
        if (left == nil || right == nil || left?.val != right?.val) {
            return false
        }
        let isOuterSymmetric = dfsUsingRecursion(left?.left, right?.right)
        var isInnerSymmetric = false
        if (isOuterSymmetric) {
            isInnerSymmetric = dfsUsingRecursion(left?.right, right?.left)
        }
        return isOuterSymmetric && isInnerSymmetric
    }

}
