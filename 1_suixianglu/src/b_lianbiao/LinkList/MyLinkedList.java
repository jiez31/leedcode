package b_lianbiao.LinkList;

/**
 * 单链表设计
 */
public class MyLinkedList {
    int size;
    Node head;

    /**
     * 注意初始化构造函数的时候，要将head初始化，并且head是个虚拟头节点，不包含在链表中，head.next才是链表的第一个节点。
     */
    public MyLinkedList() {
        size = 0;
        head = new Node(0);
    }

    //获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1
    public int get(int index){
        //下标无效
        if(index < 0 || index >= size){
            return -1;
        }
        //下标有效
        Node cur = head;
        for (int i = 0; i <= index; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    // 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
    public void addAtHead(int val){
        /**
         * 不用判断是否为空，都是要加到第一个节点前面的
         */
//        //判断链表是否为空
//        if(head.next == null){
//            return;
//        }
        //链表不为空，继续插入操作
        Node cur = new Node(val);
        cur.next = head.next;
        head.next = cur;
        size++;
    }

    //将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
    public void addAtTail(int val){
        addAtIndex(size, val);
    }

    //将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中
    public void addAtIndex(int index, int val){
        Node cur = head;
        Node temp = new Node(val);
        /**
         * 不用判断是否为空，如果为空size=0;if size=0,那么index>0的话，直接返回了，index=0就是正常的加入操作了
         */
        //链表为空
//        if(size == 0){
//            if(index <= 0){
//                temp.next = null;
//                head.next = temp;
//                size++;
//                return;
//            }
//            return;
//        }
        //链表不为空
        //index > size
        if(index > size){
            return;
        }
        index = Math.max(0, index);
        //正常
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        temp.next = cur.next;
        cur.next = temp;
        size++;
    }

    //如果下标有效，则删除链表中下标为 index 的节点。
    public void deleteAtIndex(int index){
        if(index >= size || index < 0){
            return;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }


    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 双指针法： 只需要改变链表的next指针的指向，直接将链表反转 ，而不用重新定义一个新的链表，如图所示:
     */
    public Node reverseList(Node head){
        Node tail = null;
        Node cur = head;
        Node temp = null;
        while(cur != null){
            temp = cur.next;//保存下一个节点
            cur.next = tail;
            tail = cur;
            cur = temp;
        }
        return tail;
    }
}

class Node{
    int val;
    Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}





