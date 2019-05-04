package test.com.hust.linkedlist; 

import com.hust.linkedlist.ListNode;
import com.hust.linkedlist.MergeTwo;
import com.hust.linkedlist.MergeTwo2;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MergeTwo2 Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 21, 2019</pre> 
* @version 1.0 
*/ 
public class MergeTwo2Test { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: Merge(ListNode l1, ListNode l2) 
* 
*/ 
@Test
public void testMerge() throws Exception { 
//TODO: Test goes here...
    MergeTwo2 mergeTwo = new MergeTwo2();
    ListNode l1 = new ListNode(1);
    ListNode l11 = new ListNode(3);
    ListNode l12 = new ListNode(5);
    l1.next = l11;
    l11.next = l12;
    ListNode l2 = new ListNode(2);
    ListNode l21 = new ListNode(4);
    ListNode l22 = new ListNode(6);
    l2.next = l21;
    l21.next = l22;
    ListNode merge = mergeTwo.Merge(l1, l2);
    while (merge != null){

        System.out.print(merge.val+" ");
        merge = merge.next;
    }
} 


} 
