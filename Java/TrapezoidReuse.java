/**
 * TrapezoidReuse demonstrates composition by using Rectangle and Triangle objects.
 * It has a HAS-A relationship with:
 * - One Rectangle (middle section)
 * - Two Triangles (top and bottom sections)
 */
public class TrapezoidReuse {
    private Rectangle myRectangle;
    private Triangle myTriangle1; // top triangle
    private Triangle myTriangle2; // bottom triangle

    public TrapezoidReuse(double height, double topBase, double middleBase, double bottomBase) {
        // Create component objects that make up the trapezoid
        myRectangle = new Rectangle(height, middleBase);
        myTriangle1 = new Triangle(height, topBase);
        myTriangle2 = new Triangle(height, bottomBase);
    }

    public Rectangle getRectangle() {
        return myRectangle;
    }

    public Triangle getTriangle1() {
        return myTriangle1;
    }

    public Triangle getTriangle2() {
        return myTriangle2;
    }

    /**
     * Calculates total area using composition - sums the areas of components
     */
    public double calculateArea() {
        return myRectangle.calculateArea() + 
               myTriangle1.calculateArea() + 
               myTriangle2.calculateArea();
    }

    public void showComponents() {
        System.out.println("Component 1: " + myRectangle);
        System.out.println("Component 2: " + myTriangle1);
        System.out.println("Component 3: " + myTriangle2);
    }

    @Override
    public String toString() {
        return "TrapezoidReuse[height=" + myRectangle.getHeight() + 
               ", topBase=" + myTriangle1.getBase() + 
               ", middleBase=" + myRectangle.getWidth() + 
               ", bottomBase=" + myTriangle2.getBase() + "]";
    }
}