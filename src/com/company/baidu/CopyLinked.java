package com.company.baidu;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 */
public class CopyLinked {

    class LinkedNodeP {
        int val;
        LinkedNodeP next;
        LinkedNodeP point;
        LinkedNodeP(int val) {
            this.val = val;
        }
    }

    public LinkedNodeP copyLink(LinkedNodeP head) {
        // 旧节点 -> 新节点
        Map<LinkedNodeP, LinkedNodeP> map = new HashMap<>();

        // 创建新节点并保存【旧节点和新节点的对应关系】
        LinkedNodeP cur = head;
        while (cur != null) {
            map.put(cur, new LinkedNodeP(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).point = map.get(cur.point);
            cur = cur.next;
        }
        return map.get(head);
    }
}
