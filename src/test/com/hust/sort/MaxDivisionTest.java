package test.com.hust.sort; 

import com.hust.sort.MaxDivision;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

/** 
* MaxDivision Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 8, 2019</pre> 
* @version 1.0 
*/ 
public class MaxDivisionTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findMaxDivision(int[] A, int n) 
* 
*/ 
@Test
public void testFindMaxDivision() throws Exception { 
//TODO: Test goes here...
    int[] a = {138, 591};
    MaxDivision maxDivision = new MaxDivision();
    int maxDivision1 = maxDivision.findMaxDivision(a, 2);
    System.out.println(maxDivision1);
}


/** 
* 
* Method: bucket(long num, long n, long min, long max) 
* 
*/ 
@Test
public void testBucket() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = MaxDivision.getClass().getMethod("bucket", long.class, long.class, long.class, long.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
