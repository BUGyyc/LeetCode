/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (43.82%)
 * Total Accepted:    16.6K
 * Total Submissions: 37.6K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    //TODO:
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists, 0, lists.length - 1);
    }

    public ListNode mergeList(ListNode[] listNodes, int begin, int end) {
        if (begin > end) {
            return null;
        }
        if (begin == end)
            return listNodes[begin];
        int mid = (begin + end) >> 1;
        ListNode listNode1 = mergeList(listNodes, begin, mid);
        ListNode listNode2 = mergeList(listNodes, mid + 1, end);
        ListNode merges = merge(listNode1, listNode2);
        return merges;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode listNode = new ListNode(0);
        ListNode currentNode = listNode;
        while (true) {
            if (a == null && b == null) {
                break;
            } else if (a != null && (b == null || a.val <= b.val)) {
                currentNode.next = a;
                a = a.next;
            } else if (a == null || b.val < a.val) {
                currentNode.next = b;
                b = b.next;
            }
            currentNode = currentNode.next;
        }
        return listNode.next;
    }
}
