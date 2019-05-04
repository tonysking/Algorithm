package test.com.hust.tree; 

import com.hust.tree.PreorderTraversal;
import com.hust.tree.ReconstructBT;
import com.hust.tree.TreeNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;

/** 
* ReconstructBT Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 25, 2019</pre> 
* @version 1.0 
*/ 
public class ReconstructBTTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: reConstructBinaryTree(int [] pre, int [] in) 
* 
*/ 
@Test
public void testReConstructBinaryTree() throws Exception { 
//TODO: Test goes here...
    ReconstructBT reconstructBT = new ReconstructBT();
    int[] pre = {1,2,4,7,3,5,6,8};
    int[] in = {4,7,2,1,5,3,8,6};
    TreeNode treeNode = reconstructBT.reConstructBinaryTree(pre, in);
    //测试先序是否和pre一致
    PreorderTraversal preorderTraversal = new PreorderTraversal();
    ArrayList<Integer> arrayList = preorderTraversal.preorderTraversal(treeNode);
    for (int i = 0; i < arrayList.size(); i++) {
        System.out.print(arrayList.get(i)+" ");
    }
} 


/** 
* 
* Method: rePre(int[] pre, int start, int end, int[] in, int inStart, int inEnd) 
* 
*/ 
@Test
public void testRePre() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ReconstructBT.getClass().getMethod("rePre", int[].class, int.class, int.class, int[].class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
