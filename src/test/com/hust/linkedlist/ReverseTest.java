package test.com.hust.linkedlist; 

import com.hust.linkedlist.ListNode;
import com.hust.linkedlist.Reverse;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Reverse Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 1, 2019</pre> 
* @version 1.0 
*/ 
public class ReverseTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: ReverseList(ListNode head) 
* 
*/ 
@Test
public void testReverseList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: ReverseList2(ListNode head) 
* 
*/ 
@Test
public void testReverseList2() throws Exception { 
//TODO: Test goes here...
    Reverse reverse = new Reverse();
    ListNode list = ListNode.getList();
    ListNode.printListNode(list);

    ListNode reverseList2 = reverse.ReverseList2(list);
    ListNode.printListNode(reverseList2);
} 


} 
