package test.com.hust.tree; 

import com.hust.tree.VerifySquenceOfBST;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* VerifySquenceOfBST Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 26, 2019</pre> 
* @version 1.0 
*/ 
public class VerifySquenceOfBSTTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: VerifySquenceOfBST(int[] sequence) 
* 
*/ 
@Test
public void testVerifySquenceOfBST() throws Exception { 
//TODO: Test goes here...
    VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
    int[] falseTree = {7,4,6,5};
    boolean b = verifySquenceOfBST.VerifySquenceOfBST(falseTree);
    System.out.println(b);
} 


/** 
* 
* Method: isPost(int[] sequence, int start, int end) 
* 
*/ 
@Test
public void testIsPost() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = VerifySquenceOfBST.getClass().getMethod("isPost", int[].class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
