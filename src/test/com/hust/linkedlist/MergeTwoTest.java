package test.com.hust.linkedlist; 

import com.hust.linkedlist.ListNode;
import com.hust.linkedlist.MergeTwo;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MergeTwo Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 21, 2019</pre> 
* @version 1.0 
*/ 
public class MergeTwoTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: mergeTwoLists(ListNode l1, ListNode l2) 
* 
*/ 
@Test
public void testMergeTwoLists() throws Exception { 
//TODO: Test goes here...
    MergeTwo mergeTwo = new MergeTwo();
    ListNode l1 = new ListNode(1);
    ListNode l11 = new ListNode(3);
    ListNode l12 = new ListNode(5);
    l1.next = l11;
    l11.next = l12;
    ListNode l2 = new ListNode(1);
    ListNode l21 = new ListNode(3);
    ListNode l22 = new ListNode(5);
    l2.next = l21;
    l21.next = l22;
    ListNode merge = mergeTwo.mergeTwoLists(l1, l2);
    while (merge != null){

        System.out.print(merge.val+" ");
        merge = merge.next;
    }


} 


} 
