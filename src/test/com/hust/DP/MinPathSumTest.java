package test.com.hust.DP; 

import com.hust.DP.MinPathSum;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MinPathSum Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 27, 2019</pre> 
* @version 1.0 
*/ 
public class MinPathSumTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: minPathSum(int[][] grid) 
* 
*/ 
@Test
public void testMinPathSum() throws Exception { 
//TODO: Test goes here...
    MinPathSum minPathSum = new MinPathSum();
    int[][] path = {
            {1,2},
            {1,1}
    };
    int min = minPathSum.minPathSum(path);
    System.out.println(min);
} 


} 
