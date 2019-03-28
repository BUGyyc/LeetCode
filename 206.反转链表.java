/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (59.36%)
 * Total Accepted:    44.4K
 * Total Submissions: 74.7K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return func1(head, null);
    }

    /**
     * 递归
     * @param node
     * @return
     */
    private ListNode func1(ListNode head,ListNode newHead){
        if(head == null)return newHead;
        ListNode next = head.next;
        head.next =newHead;
        return func1(next, head);
    }
}
