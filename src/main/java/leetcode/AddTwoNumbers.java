package leetcode;

import java.util.List;

/**
 * Created by yuanzhuo on 2017/2/20.
 */
public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     */

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; next = null;}
      }

    public static void printList(ListNode ln){
        while (ln != null){
            System.out.print(ln.val);
            ln = ln.next;
        }
        System.out.println();
    }

    //正序列表： 100 ： 1->0->0
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null)
            return l2;
        if (l1 != null && l2 == null)
            return l1;
        if (l1 == null && l2 == null)
            return null;

        ListNode la =  new ListNode(l1.val);;
        ListNode lb =  new ListNode(l2.val);;
        ListNode result = new ListNode(0);

        while (l1.next != null){
            ListNode tmp =  new ListNode(l1.next.val);
            tmp.next = la;
            la = tmp;
            l1 = l1.next;
        }
        while (l2.next != null){
            ListNode tmp = new ListNode(l2.next.val);
            tmp.next = lb;
            lb = tmp;
            l2 = l2.next;
        }

        int over_ten = 0;
        while(la!=null && lb != null){
            int add = la.val + lb.val + over_ten;
            over_ten = add / 10;
            add = add % 10;
            result.val += add;
            ListNode head = new ListNode(0);
            head.next = result;
            result = head;
            la = la.next;
            lb = lb.next;
        }

        la = la == null?lb:la;
        while (la != null){
            int add = la.val + over_ten;
            over_ten = add / 10;
            add = add % 10;
            result.val += add;
            ListNode head = new ListNode(0);
            head.next = result;
            result = head;
            la=la.next;
        }

        result = result.next;
        //printList(result);

        return result;
    }

    //反序列表： 100 ： 1->0->0
    public static ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null)
            return l2;
        if (l1 != null && l2 == null)
            return l1;
        if (l1 == null && l2 == null)
            return null;

        ListNode la =  l1;;
        ListNode lb =  l2;
        ListNode result = new ListNode(0);
        ListNode tail = result;

        int over_ten = 0;
        while(la!=null && lb != null){
            ListNode new_tail = new ListNode(0);
            int add = la.val + lb.val + over_ten;
            over_ten = add / 10;
            add = add % 10;
            new_tail.val += add;
            tail.next = new_tail;
            tail = new_tail;
            la = la.next;
            lb = lb.next;
        }

        la = la == null?lb:la;
        while (la != null){
            ListNode new_tail = new ListNode(0);
            int add = la.val + over_ten;
            over_ten = add / 10;
            add = add % 10;
            new_tail.val += add;
            tail.next = new_tail;
            tail = new_tail;
            la=la.next;
        }
        //最高位有进位
        if (over_ten != 0){
            ListNode new_tail = new ListNode(over_ten);
            tail.next = new_tail;
        }

        result = result.next;
        //printList(result);

        return result;
    }

    public static void main(String args[]){
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(9);

        addTwoNumbersReverse(a, b);
    }
}
