package test.com.hust.linkedlist; 

import com.hust.linkedlist.ListNode;
import com.hust.linkedlist.Partition;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Partition Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 1, 2019</pre> 
* @version 1.0 
*/ 
public class PartitionTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: partition(ListNode head, int x) 
* 
*/ 
@Test
public void testPartition() throws Exception { 
//TODO: Test goes here... 
    Partition partition = new Partition();

    int[] a = {5,3,2,4,6,1};
    ListNode listByArray = ListNode.createListByArray(a);
    ListNode.printListNode(listByArray);
    ListNode partition1 = partition.partition2(listByArray, 3);
    ListNode.printListNode(partition1);
} 


} 
