package test.com.hust.string; 

import com.hust.string.StrToInt;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* StrToInt Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 2, 2019</pre> 
* @version 1.0 
*/ 
public class StrToIntTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: StrToInt(String str) 
* 
*/ 
@Test
public void testStrToInt() throws Exception { 
//TODO: Test goes here...
    StrToInt strToInt = new StrToInt();
    int res = strToInt.StrToInt("-2147483648");
    System.out.println(res);
} 


/** 
* 
* Method: isValid(char[] chas) 
* 
*/ 
@Test
public void testIsValid() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = StrToInt.getClass().getMethod("isValid", char[].class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
