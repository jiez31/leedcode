package b_lianbiao;

import b_lianbiao.LinkList.SingleLinkedList;
import b_lianbiao.LinkList.SingleLinkedList.*;

/**
 *移除链表元素
 * 删除链表中等于给定值 val 的所有节点。输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]   输入：head = [], val = 1 输出：[]   输入：head = [7,7,7,7], val = 7 输出：[]
 *
 */
public class movelianbiao {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.ceshi1();

    }
}

//答案
//    public ListNode removeElements(ListNode head, int val) {
//        while(head!=null && head.val==val) {
//            head = head.next;
//        }
//        ListNode curr = head;
//        while(curr!=null && curr.next !=null) {
//            if(curr.next.val == val){
//                curr.next = curr.next.next;
//            } else {
//                curr = curr.next;
//            }
//        }
//        return head;
//    }
