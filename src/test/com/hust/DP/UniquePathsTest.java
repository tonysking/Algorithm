package test.com.hust.DP; 

import com.hust.DP.UniquePaths;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* UniquePaths Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 30, 2019</pre> 
* @version 1.0 
*/ 
public class UniquePathsTest { 

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
    UniquePaths uniquePaths = new UniquePaths();
    int paths = uniquePaths.uniquePaths(3, 7);
    System.out.println(paths);
} 


/** 
* 
* Method: move(int sr, int sc, int m, int n, int[][] path, int count) 
* 
*/ 
@Test
public void testMove() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = UniquePaths.getClass().getMethod("move", int.class, int.class, int.class, int.class, int[][].class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
