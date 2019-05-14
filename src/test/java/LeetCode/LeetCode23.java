package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: QAproject
 * @description: k个有序链表合并
 * @author: bjweiman
 * @create: 2019-04-02 21:55
 **/
public class LeetCode23 {
        public static ListNode mergeKLists(ListNode[] lists) {
            if(lists == null) return null;
            if(lists.length == 1 || lists.length == 0)  return null;
            ListNode listNode = lists[0];
            for(int i=1; i<lists.length; i++){
                listNode=mergeTwoLists(listNode,lists[i]);
            }

            return listNode;
        }

        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null && l2 == null){
                return null;
            }

            if (l1 == null) return l2;
            if (l2 == null) return l1;

            if(l1.val >=l2.val){
                ListNode newNode = new ListNode(l2.val);
                newNode.next = mergeTwoLists(l1,l2.next);
                return newNode;

            }else{
                ListNode newNode =  new ListNode(l1.val);
                newNode.next = mergeTwoLists(l1.next,l2);
                return newNode;

            }
        }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        List<ListNode> listNodes = new ArrayList<>();
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node4;
        node4.next = node5;
        listNodes.add(node1);

        ListNode node21 = new ListNode(1);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(4);
        node21.next = node23;
        node23.next = node24;
        listNodes.add(node21);

        ListNode node32 = new ListNode(2);
        ListNode node36 = new ListNode(6);
        node32.next = node36;
        listNodes.add(node32);
        ListNode[] listNodes1 = new ListNode[listNodes.size()];
        listNodes.toArray(listNodes1);


        System.out.println(mergeKLists(listNodes1));
    }

}
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

     @Override
     public String toString() {
        String str= "";
        ListNode node = this;
        while (node!= null){
            str = node.val+",";
            node = node.next;
        }

         return str;
     }
 }