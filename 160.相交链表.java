/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] ????
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // return extracted(headA, headB);
        return extracted(headA, headB);
    }

    // private ListNode extracted(ListNode headA, ListNode headB) {
    // Set<ListNode> set = new HashSet<>();
    // while (headA != null) {
    // set.add(headA);
    // headA = headA.next;
    // }
    // while (headB != null) {
    // if (set.contains(headB)) {
    // return headB;
    // } else {
    // headB = headB.next;
    // }
    // }
    // return null;
    // }
    // 0\n[1]\n[2]\n1\n1
    private ListNode extracted(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int l1 = 0, l2 = 0;
        ListNode n1 = headA;
        ListNode n2 = headB;
        while (n1 != null) {
            n1 = n1.next;
            l1++;
        }
        while (n2 != null) {
            n2 = n2.next;
            l2++;
        }
        // ??
        ListNode longLink = (l1 > l2) ? headA : headB;
        // ??
        ListNode shortLink = (l1 < l2) ? headA : headB;
        // ????
        int dis = (l1 > l2) ? (l1 - l2) : (l2 - l1);
        while (dis >= 0) {
            dis--;
            longLink = longLink.next;// (longLink != null) ? longLink.next : longLink;
        }
        while (longLink != null && shortLink != null) {
            if (longLink == shortLink && longLink != null) {
                return longLink;
            }
            longLink = longLink.next;
            shortLink = shortLink.next;
        }
        return null;
    }
}
