package com.test.leetcode.linkedlist;

public class LinkedList02 {
    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1340 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode a = head;
        int length = 0;
        while (a != null) {
            a = a.next;
            length++;
        }
        if (n > length) throw new IllegalArgumentException();
        int parentPosition = length - n;
        if (parentPosition == 0) return head.next;
        ListNode parentNode = head;
        while (parentPosition > 1) {
            parentNode = parentNode.next;
            parentPosition--;
        }
        parentNode.next = parentNode.next.next;
        return head;
    }

    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int spacing = n;
        ListNode pointerA = head;
        ListNode pointerB = head;
        while (spacing > 0) {
            pointerB = pointerB.next;
            spacing--;
        }
        if (pointerB == null) return pointerA.next;
        while (pointerB.next != null) {
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        pointerA.next = pointerA.next.next;
        return head;
    }
//leetcode submit region end(Prohibit modification and deletion)

}
