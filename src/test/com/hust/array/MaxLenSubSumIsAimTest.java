package test.com.hust.array; 

import com.hust.array.MaxLenSubSumIsAim;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MaxLenSubSumIsAim Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 9, 2019</pre> 
* @version 1.0 
*/ 
public class MaxLenSubSumIsAimTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: maxLength(int[] a, int k) 
* 
*/ 
@Test
public void testMaxLength() throws Exception {
//TODO: Test goes here...
    MaxLenSubSumIsAim maxLenSubSumIsAim = new MaxLenSubSumIsAim();
    int[] a = {7,3,2,1,1,7,-6,-1,7};
    int i = maxLenSubSumIsAim.maxLength(a, 7);
    System.out.println(i);
} 


} 
