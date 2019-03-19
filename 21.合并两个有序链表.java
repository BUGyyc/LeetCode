/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (52.91%)
 * Total Accepted:    51.4K
 * Total Submissions: 96.6K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode newList = new ListNode(-1);
        ListNode head = newList;
        while (l1 != null || l2 != null) {// 只要不为空就比较下去
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    newList.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    newList.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                newList.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l2 != null) {
                newList.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            newList = newList.next;
        }
        return head.next;
    }
}
