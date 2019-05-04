package test.com.hust.array; 

import com.hust.array.InversePairs;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* InversePairs Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 22, 2019</pre> 
* @version 1.0 
*/ 
public class InversePairsTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: InversePairs(int[] array) 
* 
*/ 
@Test
public void testInversePairs() throws Exception { 
//TODO: Test goes here...
    InversePairs inversePairs = new InversePairs();
    int testTime = 50;
    int maxSize = 100000;
    int maxValue = 10000;
    boolean succeed = true;
    for (int i = 0; i < testTime; i++) {
        int[] arr1 = inversePairs.generateRandomArray(maxSize, maxValue);
        int[] arr2 = inversePairs.copyArray(arr1);
        int i1 = inversePairs.InversePairs(arr1);
        int i2 = inversePairs.InversePairs2(arr2);
        if (i1 != i2) {
            succeed = false;
            inversePairs.printArray(arr1);System.out.println("得到的逆序对数"+i1);
            inversePairs.printArray(arr2);System.out.println("实际的逆序对数"+i2);
//            break;
        }
    }
    System.out.println(succeed ? "Nice!" : "Fucking fucked!");

} 

/** 
* 
* Method: InversePairs2(int[] array) 
* 
*/ 
@Test
public void testInversePairs2() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: generateRandomArray(int maxSize, int maxValue) 
* 
*/ 
@Test
public void testGenerateRandomArray() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: printArray(int[] arr) 
* 
*/ 
@Test
public void testPrintArray() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: copyArray(int[] arr) 
* 
*/ 
@Test
public void testCopyArray() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: mergeSortInverse(int[] array, int l, int r) 
* 
*/ 
@Test
public void testMergeSortInverse() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = InversePairs.getClass().getMethod("mergeSortInverse", int[].class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: mergeInverse(int[] a, int l, int mid, int r) 
* 
*/ 
@Test
public void testMergeInverse() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = InversePairs.getClass().getMethod("mergeInverse", int[].class, int.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
