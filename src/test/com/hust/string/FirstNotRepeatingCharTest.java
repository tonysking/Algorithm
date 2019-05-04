package test.com.hust.string; 

import com.hust.string.FirstNotRepeatingChar;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

/** 
* FirstNotRepeatingChar Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 31, 2019</pre> 
* @version 1.0 
*/ 
public class FirstNotRepeatingCharTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: FirstNotRepeatingChar(String str) 
* 
*/ 
@Test
public void testFirstNotRepeatingChar() throws Exception { 
//TODO: Test goes here...
    FirstNotRepeatingChar firstNotRepeatingChar = new FirstNotRepeatingChar();
    int index = firstNotRepeatingChar.FirstNotRepeatingChar2("google");
    System.out.println(index);
} 


} 
