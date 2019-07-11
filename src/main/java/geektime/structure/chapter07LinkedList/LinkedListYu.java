package geektime.structure.chapter07LinkedList;

import geektime.structure.chapter06LinkedList.SNode;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * Author: Yu
 */
public class LinkedListYu {

    /**
     * 单链表反转
     * @param list
     * @return
     */
    public static SNode reverse(SNode list) {
        SNode pre = null;
        SNode curr = list;
        while(curr != null){
            SNode next = curr.getNext();
            curr.setNext(pre);
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 检测环
     * @param list
     * @return
     */
    public static boolean checkCircle(SNode list) {

        if(list == null)return false;

        SNode slow = list;
        SNode fast = list.getNext();

        while(slow != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    /**
     * 两个有序的链表合并
     * @param l1
     * @param l2
     * @return
     */
    public SNode<Integer> mergeTwoLists(SNode<Integer> l1, SNode<Integer> l2) {
        SNode<Integer> soilder = new SNode<>(0);
        SNode p  =  soilder;

        while(l1 !=  null && l2 != null){
            if(l1.getElement() < l2.getElement()){
                p.setNext(l1);
                l1 = l1.getNext();
            }else {
                p.setNext(l2);
                l2 = l2.getNext();
            }
            p =  p.getNext();
        }

        if(l1 == null){
            p.setNext(l1);
        }
        if(l2 == null){
            p.setNext(l2);
        }
        return soilder.getNext();
    }

    /**
     * 删除倒数第K个结点
     */
    public static SNode deleteLastKth(SNode list, int k){

        SNode fast = list;
        SNode slow = list;

        int i = 1;
        while(fast != null && i < k){
            fast = fast.getNext();
            i++;
        }

        if(fast == null){
            return list;
        }

        SNode pre = null;
        while(fast.getNext() != null){
            fast = fast.getNext();
            pre = slow;
            slow = slow.getNext();
        }

        if(pre == null){
            list = list.getNext();
        }else{
            pre.setNext(pre.getNext().getNext());
        }
        return list;
    }

    /**
     * 求中间结点
     * @param list
     * @return
     */
    public static SNode findMiddleNode(SNode list) {
        SNode fast = list;
        SNode slow = list;

        if(list == null) return null;

        while(fast.getNext() != null && fast.getNext().getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;
    }

}
