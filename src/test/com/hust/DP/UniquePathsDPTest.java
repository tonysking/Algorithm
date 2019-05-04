package test.com.hust.DP; 

import com.hust.DP.UniquePathsDP;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

/** 
* UniquePathsDP Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 30, 2019</pre> 
* @version 1.0 
*/ 
public class UniquePathsDPTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: uniquePaths(int m, int n) 
* 
*/ 
@Test
public void testUniquePaths() throws Exception { 
//TODO: Test goes here...
    UniquePathsDP uniquePathsDP = new UniquePathsDP();
    int paths = uniquePathsDP.uniquePaths(3, 7);
    int pathsBetter = uniquePathsDP.uniquePathsBetter(3, 7);
    System.out.println(paths+"优化算法后"+pathsBetter);
} 


} 
