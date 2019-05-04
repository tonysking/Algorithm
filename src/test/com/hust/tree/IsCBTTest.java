package test.com.hust.tree; 

import com.hust.tree.IsBST;
import com.hust.tree.IsCBT;
import com.hust.tree.SerializeAndDeserialize;
import com.hust.tree.TreeNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* IsCBT Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 12, 2019</pre> 
* @version 1.0 
*/ 
public class IsCBTTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: isCBT(TreeNode root) 
* 
*/ 
@Test
public void testIsCBT() throws Exception { 
//TODO: Test goes here...

    /*
            1
           2 3
            4
     */
    TreeNode deserialize = SerializeAndDeserialize.Deserialize("1!2!#!4!#!#!3!#!#!");

    IsCBT isCBT = new IsCBT();
    boolean shouldTrue = isCBT.isCBT(TreeNode.getTree());
    boolean shouldNotTrue = isCBT.isCBT(deserialize);
    System.out.println("完全"+shouldTrue+"不完全"+shouldNotTrue);

} 


} 
