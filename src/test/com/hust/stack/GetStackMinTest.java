package test.com.hust.stack; 

import com.hust.stack.GetStackMin;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* GetStackMin Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 19, 2019</pre> 
* @version 1.0 
*/ 
public class GetStackMinTest { 

@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: push(int node) 
* 
*/ 
@Test
public void testPush() throws Exception { 
//TODO: Test goes here...
    GetStackMin getStackMin = new GetStackMin();
    getStackMin.push(3);
    getStackMin.push(4);
    int min = getStackMin.min();
    System.out.println(min);
    

} 

/** 
* 
* Method: pop() 
* 
*/ 
@Test
public void testPop() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: top() 
* 
*/ 
@Test
public void testTop() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: min() 
* 
*/ 
@Test
public void testMin() throws Exception { 
//TODO: Test goes here... 
} 


} 
