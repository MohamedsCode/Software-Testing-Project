package sw;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class insertRecTest {

    @Test
    public void test() {
        BinaryTree tree = new BinaryTree();

        Student s1 = new Student("Alice", 3.0, Arrays.asList("Math"));
        Student s2 = new Student("Bob", 3.5, Arrays.asList("Science", "Math"));
        Student s3 = new Student("Charlie", 4.0, Arrays.asList("History", "Math", "Science"));

        tree.insert(s1);
        tree.insert(s2);
        tree.insert(s3);

        List<Student> result = tree.inOrderTraversal();

        assertEquals("Alice", result.get(0).name);
        assertEquals("Bob", result.get(1).name);
        assertEquals("Charlie", result.get(2).name);
    }
    
    
    
    @Test
    public void testDuplicateNameDifferentGPA() {
        BinaryTree tree = new BinaryTree();

        Student s1 = new Student("Alice", 3.0, Arrays.asList("Math"));
        Student s2 = new Student("Alice", 3.5, Arrays.asList("Science"));

        tree.insert(s1);
        tree.insert(s2);

        List<Student> result = tree.inOrderTraversal();

        assertEquals(2, result.size());
        assertEquals(3.0, result.get(0).gpa);
        assertEquals(3.5, result.get(1).gpa);
        assertNotEquals(result.get(0).gpa, result.get(1).gpa);
    }
    
 
    
    @Test
    public void testDuplicateNameAndGPA_DifferentCourses() {
        BinaryTree tree = new BinaryTree();

        Student s1 = new Student("Alice", 3.8, Arrays.asList("Math"));              
        Student s2 = new Student("Bob", 3.8, Arrays.asList("Math", "Science"));    

        tree.insert(s2); 
        tree.insert(s1);

        List<Student> result = tree.inOrderTraversal();

        assertEquals(2, result.size());        
        assertTrue(result.get(0).courses.size() < result.get(1).courses.size());
    }

    

    @Test
    public void testExactDuplicateStudents() {
        BinaryTree tree = new BinaryTree();

        List<String> courses = Arrays.asList("Math", "Science");

        Student s1 = new Student("Alice", 3.7, courses);
        Student s2 = new Student("Alice", 3.7, courses); // exact same student

        tree.insert(s1);
        tree.insert(s2);

        List<Student> result = tree.inOrderTraversal();

        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).name);
        assertEquals("Alice", result.get(1).name);
        assertEquals(result.get(0).gpa, result.get(1).gpa);
        assertEquals(result.get(0).courses.size(), result.get(1).courses.size());
    }


      
}
