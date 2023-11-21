package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import main.Triangle;

class TriangleTest {

    private Triangle defaultTriangle;

    @BeforeEach
    void setUp() {
        defaultTriangle = new Triangle();
    }

    @Test
    @DisplayName("Default Triangle constructor without values")
    void testDefaultTriangleConstructorNull(){
        assertNull(defaultTriangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Default Triangle constructor setted with values")
    void testTriangleSetter(){
        defaultTriangle.setCurrent_type(3,3,3);
        assertEquals(Triangle.TYPE.EQUILATERAL, defaultTriangle.getCurrent_type());
    }
        
    @Test
    @DisplayName("Standard Triangle constructor")
    void testTriangleConstructorWithInts() {
    	Triangle equilateralTriangle = new Triangle(4,4,4);
    	assertEquals(Triangle.TYPE.EQUILATERAL, equilateralTriangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Triangle constructor with String array")
    void testTriangleArrayConstructor() {
        String[] values = {"4","4","4"};
        Triangle arrayEquilateralTriangle = new Triangle(values);
        assertEquals(Triangle.TYPE.EQUILATERAL, arrayEquilateralTriangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Triangle constructor with too many values as String array")
    void testTriangleArrayConstructorTooManyValues() {
        String[] values = {"4","4","4","4"};
        Triangle arrayEquilateralTriangle = new Triangle(values);
        assertNull(arrayEquilateralTriangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Triangle constructor with non-numberic values as String array")
    void testTriangleArrayConstructorNumberFormatException() {
        String[] values = {"four","four","four"};
        Triangle triangleWithTextValue = new Triangle(values);
        assertNull(triangleWithTextValue.getCurrent_type());
    }
    
    @Test
    @DisplayName("Identify the triangle with one minus value as null")
    void testTriangleTypeNullWithOneMinusValue() {
        Triangle notTriangle = new Triangle(4,-1,4);
        assertNull(notTriangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("Identify the triangle with one side too long as null")
    void testTriangleTypeNullOneSideTooLong() {
        Triangle notTriangle = new Triangle(2,4,100);
        assertNull(notTriangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("String representation of the triangle with one side too long")
    void testTriangleTypeNullOneSideTooLongToString() {
        Triangle notTriangle = new Triangle(2,4,100);
        assertEquals("2, 4, 100, This is not a triangle", notTriangle.toString());
    }

    @Test
    @DisplayName("Identify the triangle type as scalene")
    void testTriangleTypeScalene() {
        Triangle scaleneTriangle = new Triangle(7,6,5);
        assertEquals(Triangle.TYPE.SCALENE, scaleneTriangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("String representation of the triangle as scalene")
    void testTriangleTypeScaleneToString() {
        Triangle scaleneTriangle = new Triangle(7,6,5);
        assertEquals("7, 6, 5, This is a Scalene triangle", scaleneTriangle.toString());
    }
    
    @Test
    @DisplayName("Identify the triangle type as isosceles")
    void testTriangleTypeIsosceles() {
        Triangle isoscelesTriangle = new Triangle(10,2,10);
        assertEquals(Triangle.TYPE.ISOSCELES, isoscelesTriangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("String representation of the triangle as isosceles")
    void testTriangleTypeIsoscelesToString() {
        Triangle isoscelesTriangle = new Triangle(10,2,10);
        assertEquals("10, 2, 10, This is a Isosceles triangle", isoscelesTriangle.toString());
    }

    @Test
    @DisplayName("Identify the triangle type as equilateral")
    void testTriangleTypeEquilateral() {
        Triangle equilateralTriangle = new Triangle(50,50,50);
        assertEquals(Triangle.TYPE.EQUILATERAL, equilateralTriangle.getCurrent_type());
    }
    
    @Test
    @DisplayName("String representation of the triangle as equilateral")
    void testTriangleTypeEquilateralToString() {
        Triangle equilateralTriangle = new Triangle(50,50,50);
        assertEquals("50, 50, 50, This is a Equilateral triangle", equilateralTriangle.toString());
    }
    
    @Test
    @DisplayName("Test if triangles created by user input and constructor are of equal types")
    void testUserInput() {
        Triangle triangle = new Triangle(3,4,5);
        
        Triangle triangleWithInput = new Triangle();
        String input = "3,4,5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        triangleWithInput.getUserInput();

        assertEquals(triangle.getCurrent_type(), triangleWithInput.getCurrent_type());
    }
    
    @Test
    @DisplayName("Identify invalid user input with non-numberic values as null")
    void testUserInputUncorrect() {
        Triangle triangleWithInput = new Triangle();
        
        String input = "I, am, non-numberic";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        triangleWithInput.getUserInput();

        assertNull(triangleWithInput.getCurrent_type());
    }
    
    @Test
    @DisplayName("Identify invalid user input with too many values as null")
    void testUserInputTooManyValues() {
        Triangle triangleWithInput = new Triangle();
        
        String input = "0, 3, 2, 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        triangleWithInput.getUserInput();

        assertNull(triangleWithInput.getCurrent_type());
    }
}
