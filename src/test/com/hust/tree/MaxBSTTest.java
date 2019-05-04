package test.com.hust.tree; 

import com.hust.tree.MaxBST;
import com.hust.tree.PrintByLevel;
import com.hust.tree.SerializeAndDeserialize;
import com.hust.tree.TreeNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;

/** 
* MaxBST Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 10, 2019</pre> 
* @version 1.0 
*/ 
public class MaxBSTTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getMaxBST(TreeNode root) 
* 
*/ 
@Test
public void testGetMaxBST() throws Exception { 
//TODO: Test goes here...
    SerializeAndDeserialize serializeAndDeserialize = new SerializeAndDeserialize();
    String tree = "6!1!0!#!#!3!#!#!12!10!4!2!#!#!5!#!#!14!11!#!#!15!#!#!13!20!#!#!16!#!#!";
    TreeNode root = serializeAndDeserialize.Deserialize(tree);

    MaxBST maxBST = new MaxBST();
    TreeNode maxBST1 = maxBST.getMaxBST(root);

    PrintByLevel printByLevel = new PrintByLevel();
    ArrayList<ArrayList<Integer>> print = printByLevel.Print(maxBST1);
    System.out.println(print);
} 


/** 
* 
* Method: processBST(TreeNode root) 
* 
*/ 
@Test
public void testProcessBST() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = MaxBST.getClass().getMethod("processBST", TreeNode.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
