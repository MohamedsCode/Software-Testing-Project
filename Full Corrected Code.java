package sw;

import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    double gpa;
    List<String> courses;

    public Student(String name, double gpa, List<String> courses) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
        this.name = name;
        this.gpa = gpa;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return name + " (GPA: " + gpa + ", Courses: " + courses.size() + ")";
    }
}

class TreeNode {
    Student student;
    TreeNode left;
    TreeNode right;

    public TreeNode(Student student) {
        this.student = student;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    private TreeNode root;

    public void insert(Student student) {
        if (root == null) {
            root = new TreeNode(student);
        } else {
            insertRec(root, student);
        }
    }

    public void insertRec(TreeNode node, Student student) {
    	// ERROR INTRODUCED HERE: Swapped comparison operators
        if (student.gpa < node.student.gpa) { // Should be < for left subtree
            if (node.left == null) {
                node.left = new TreeNode(student);
            } else {
                insertRec(node.left, student);
            }
        } else if (student.gpa > node.student.gpa) { // Should be > for right subtree
            if (node.right == null) {
                node.right = new TreeNode(student);
            } else {
                insertRec(node.right, student);
            }
        } else { // If GPA is the same, compare by number of courses
            if (student.courses.size() < node.student.courses.size()) {
                if (node.left == null) {
                    node.left = new TreeNode(student);
                } else {
                    insertRec(node.left, student);
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(student);
                } else {
                    insertRec(node.right, student);
                }
            }
        }
    }

    public List<Student> inOrderTraversal() {
        List<Student> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    public void inOrderRec(TreeNode node, List<Student> result) {
        if (node != null) {
            inOrderRec(node.left, result);
            result.add(node.student);
            inOrderRec(node.right, result);
        }
    }
}

public class BinaryTreeStudents {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.5, List.of("Math", "Science")));
        students.add(new Student("Bob", 3.8, List.of("Math", "English", "History")));
        students.add(new Student("Charlie", 3.5, List.of("Math")));
        students.add(new Student("Diana", 3.9, List.of("Science", "History")));
        students.add(new Student("Eve", 3.8, List.of("Math", "Science", "Art")));

        BinaryTree tree = new BinaryTree();
        for (Student student : students) {
            tree.insert(student);
        }

        System.out.println("Students in sorted order:");
        for (Student student : tree.inOrderTraversal()) {
            System.out.println(student);
        }
    }
}
