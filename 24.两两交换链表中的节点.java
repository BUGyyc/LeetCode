/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (57.73%)
 * Total Accepted:    15.6K
 * Total Submissions: 26.9K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
        // ListNode jList = new ListNode(-1);//奇
        // ListNode jHead = jList;
        // ListNode oList = new ListNode(-1);//偶
        // ListNode oHead = oList;
        // ListNode newHead = new ListNode(-1);
        // ListNode cur = head;
        // int i =1;
        // while(cur!=null){
        //     if(i%2 == 0){
        //         oList.next = new ListNode(cur.val);
        //         oList = oList.next;
        //     }else{
        //         jList.next = new ListNode(cur.val);
        //         jList = jList.next;
        //     }
        //     cur = cur.next;
        //     i++;
        // }
        // i = 1;
        // jHead = jHead.next;
        // oHead = oHead.next;
        // cur = newHead;
        // while(jHead!=null || oHead!=null){
        //     if(i%2==0){
        //         newHead.next = new ListNode(jHead.val);
        //     }else{
        //         newHead.next = new ListNode(oHead.val);
        //     }
        //     i++;
        // }
        // return cur.next;
    }
}

