package test.com.hust.dfs; 

import com.hust.dfs.CyclicPrintMatrix;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* CyclicPrintMatrix Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 14, 2019</pre> 
* @version 1.0 
*/ 
public class CyclicPrintMatrixTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: cyclicPrint(int sr, int sc, int[][] m) 
* 
*/ 
@Test
public void testCyclicPrint() throws Exception { 
//TODO: Test goes here...
    CyclicPrintMatrix cyclicPrintMatrix = new CyclicPrintMatrix();
    int[][] a = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };
    int[][] b = {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
    };
    int[][] c = {
            {1},
            {2},
            {3},
            {4},
            {5}
    };
    int[][] d = {
            {1,2,3,4,5}
    };
    System.out.println(b.length);
    cyclicPrintMatrix.cyclicPrint(0,0,d,0);

} 


} 
