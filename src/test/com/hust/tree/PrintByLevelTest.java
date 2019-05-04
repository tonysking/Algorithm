package test.com.hust.tree; 

import com.hust.tree.PrintByLevel;
import com.hust.tree.TreeNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;

/** 
* PrintByLevel Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 25, 2019</pre> 
* @version 1.0 
*/ 
public class PrintByLevelTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: Print(TreeNode pRoot) 
* 
*/ 
@Test
public void testPrint() throws Exception { 
//TODO: Test goes here...
    TreeNode tree = TreeNode.getTree();
    PrintByLevel printByLevel = new PrintByLevel();
    ArrayList<ArrayList<Integer>> print = printByLevel.Print(tree);
    System.out.println(print);

} 


} 
