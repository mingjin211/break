package moveon;

import mobile.ListNode;

import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 786432KB
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * 输入描述
 * 输入链表长度以及链表节点值
 * 输出描述
 * 输出重排后的原链表
 * 样例输入
 * 4
 * 1
 * 2
 * 3
 * 4
 * 样例输出
 * 1
 * 4
 * 2
 * 3
 */
public class Four {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ListNode head = new ListNode(0);
        ListNode tail = new ListNode(0);
        ListNode loop = head;
        for(int i = 0 ; i < n ; i++){
            int t = in.nextInt();
            ListNode tmp = new ListNode(t);
            loop.next = tmp;
            tmp.prev = loop;
            tail = tmp;
            loop = loop.next;
        }
        ListNode start = head.next;

        ListNode end = tail;

        while (start!=null && start.next!=null){
            ListNode tmp = start.next;
            ListNode prev = end.prev;
            start.next = end;
            end.prev = start;
            end.next = tmp;
            start = tmp;
            end = prev;
            end.next = null;
            if(start == end || start.next == end){
                break;
            }
        }

        ListNode loopStart = head.next;
        while (loopStart!=null){
            System.out.println(loopStart.val);
            loopStart = loopStart.next;
        }

    }


}
