package sw;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class inputValidationTest {

    // Valid edge cases: 0.0, 4.0
    @Test
    void testValidGPA_BoundaryValues() {
        BinaryTree tree = new BinaryTree();

        Student s1 = new Student("MinGPA", 0.0, Arrays.asList("Math"));
        Student s2 = new Student("MaxGPA", 4.0, Arrays.asList("Science"));
        Student s3 = new Student("MidGPA", 2.0, Arrays.asList("English"));

        tree.insert(s1);
        tree.insert(s2);
        tree.insert(s3);

        List<Student> result = tree.inOrderTraversal();

        assertEquals(3, result.size());
        assertEquals("MinGPA", result.get(0).name);
        assertEquals("MidGPA", result.get(1).name);
        assertEquals("MaxGPA", result.get(2).name);
    }

  
    
    // Invalid GPA below 0.0
    @Test
    void testInvalidGPA_LessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("NegativeGPA", -0.1, Arrays.asList("Physics"));
        });
    }

    
    
    // Invalid GPA above 4.0
    @Test
    void testInvalidGPA_GreaterThanFour() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("OverGPA", 4.1, Arrays.asList("Chemistry"));
        });
    }
    
    

    // Valid mid-range GPA values
    @Test
    void testValidGPA_MidRangeValues() {
        BinaryTree tree = new BinaryTree();

        Student s1 = new Student("Alice", 2.5, Arrays.asList("Art"));
        Student s2 = new Student("Bob", 3.5, Arrays.asList("Music"));
        Student s3 = new Student("Charlie", 3.0, Arrays.asList("Biology"));

        tree.insert(s1);
        tree.insert(s2);
        tree.insert(s3);

        List<Student> result = tree.inOrderTraversal();
        assertEquals(3, result.size());
    }
    
  
   
}
