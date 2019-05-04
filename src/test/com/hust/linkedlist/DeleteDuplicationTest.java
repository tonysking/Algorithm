package test.com.hust.linkedlist; 

import com.hust.linkedlist.DeleteDuplication;
import com.hust.linkedlist.ListNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* DeleteDuplication Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 19, 2019</pre> 
* @version 1.0 
*/ 
public class DeleteDuplicationTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: deleteDuplication(ListNode pHead) 
* 
*/ 
@Test
public void testDeleteDuplication() throws Exception { 
//TODO: Test goes here...
    DeleteDuplication deleteDuplication = new DeleteDuplication();
    ListNode head = new ListNode(1);
    ListNode p2 = new ListNode(2);
    ListNode p3 = new ListNode(3);
    ListNode p1= new ListNode(1);
    ListNode p11= new ListNode(1);
    ListNode p4 = new ListNode(4);
    ListNode p22 = new ListNode(2);
    head.next = p2; p2.next = p3; p3.next = p1; p1.next = p11; p11.next = p4; p4.next = p22;
    // 原始链表
    ListNode.printListNode(head);
    ListNode head2 = deleteDuplication.deleteDuplication(head);
    // 删除后的原始链表
    ListNode.printListNode(head);
    // 删除后的返回的链表
    ListNode.printListNode(head2);
} 


} 
