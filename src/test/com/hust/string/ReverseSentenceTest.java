package test.com.hust.string; 

import com.hust.string.ReverseSentence;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

/** 
* ReverseSentence Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 2, 2019</pre> 
* @version 1.0 
*/ 
public class ReverseSentenceTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: ReverseSentence(String str) 
* 
*/ 
@Test
public void testReverseSentence() throws Exception { 
//TODO: Test goes here...
    ReverseSentence reverseSentence = new ReverseSentence();
    String s = reverseSentence.ReverseSentence(" ");
    System.out.println(s);
} 


} 
