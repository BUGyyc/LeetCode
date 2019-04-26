/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (38.82%)
 * Total Accepted:    7.4K
 * Total Submissions: 18.9K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // return extracted(head);
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next; // while loop to find the last node of the dups.
            }
            if (slow.next != fast) { // duplicates detected.
                slow.next = fast.next; // remove the dups.
                fast = slow.next; // reposition the fast pointer.
            } else { // no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }

        }
        return dummy.next;
    }

    private ListNode extracted(ListNode head) {
        if (head == null)
            return head;
        ListNode temp = head;
        ListNode cur = temp;
        head = head.next;
        while (head != null) {
            if (head.val != cur.val) {
                cur.next = new ListNode(head.val);
            }
            head = head.next;
        }
        return temp;
    }
}
