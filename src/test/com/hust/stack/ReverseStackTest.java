package test.com.hust.stack; 

import com.hust.stack.ReverseStack;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ReverseStack Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 19, 2019</pre> 
* @version 1.0 
*/ 
public class ReverseStackTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: reverseStackRecursively(int[] stack, int top) 
* 
*/ 
@Test
public void testReverseStackRecursively() throws Exception { 
//TODO: Test goes here...
    ReverseStack reverseStack = new ReverseStack();
    int stack[] = {1,2,3,4,5};
    int[] ints = reverseStack.reverseStackRecursively(stack, 5);
    for (int i = 0; i < ints.length; i++) {

        System.out.println(ints[i]);
    }

}


} 
