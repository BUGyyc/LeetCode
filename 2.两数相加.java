/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (33.03%)
 * Total Accepted:    98.6K
 * Total Submissions: 296.2K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    //carry来计进位值。有进位则传递到下一个值
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        int carry = 0;
        ListNode listNode = new ListNode(-1);//创建一个空节点
        ListNode head = listNode;//头结点指向一个空节点
        while (l1 != null || l2 != null) {
            int sum = carry;
            carry = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int newVal = sum;//进位值与 l1、l2的值得和
            if (sum >= 10) {
                carry = 1;// 进位
                newVal = sum % 10;// 取余数
            }
            listNode.next = new ListNode(newVal);//指向下一个节点，这个节点就是求和进位后的值
            listNode = listNode.next;
        }
        if (carry > 0) {
            listNode.next = new ListNode(1);// carry不可能超过1，所以直接写1了
        }
        return head.next;
    }
}
