#TC: O(n)
#SC: O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return
        one = None
        two = head
        third = two.next
        if not third:
            return head
        
        while(two.next):
            two.next = one
            one = two
            print(two.val)
            two = third
            third = third.next
        two.next = one
        return two
