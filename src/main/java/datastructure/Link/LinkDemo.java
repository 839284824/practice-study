package datastructure.Link;

import lombok.extern.slf4j.Slf4j;

/**
 * @Desc
 * @Author gongzhao
 * @Date 2019/9/1816:21
 */
@Slf4j
public class LinkDemo {


    public static Node reverseLink(Node head) {
        /**定义两个指针 pre 用来指定反转后的节点
         ，next 指针指向需要反转的下一个节点，
         next的作用是防止链表断裂。
         要点是使用三个指针不停的变换位置来反转(自己画图理解最快)
         */

        Node next = null;
        Node pre = null;

        //当dead节点为空是退出循环，反转结束，
        while (head != null) {
            //1，先将需要反转的节点的下一个节点保存下来，防止链表断裂
            next = head.next;
            //2，将当前节点的next指向pre，这一步是真正的反转
            head.next = pre;
            //3，反转完成后需要把前一个节点指向当前的节点，
            pre = head;
            //4，将当前节点指向第一步保存的后一个节点
            head = next;
        }
        //5，经过上面的循环后，pre节点就是反转后的头结点
        return pre;
    }

    public static void main(String[] arg) {
        //create a new link 1 2 3 4 5
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;
        Node node5 = new Node(5);
        node4.next = node5;

        log.info("反转前:{}", node1);
        log.info("反转后:{}", reverseLink(node1));

    }
}
