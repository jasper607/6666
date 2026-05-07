public class TestTrapezoid {
    public static void main(String[] args) {
        System.out.println("=== TRAPEZOID COMPOSITION LAB ===\n");
        
        // Test parameters
        double height = 10.0;
        double topBase = 8.0;
        double middleBase = 20.0;
        double bottomBase = 12.0;
        
        // ===== APPROACH 1: Direct Calculation =====
        System.out.println("--- Approach 1: Direct Calculation ---");
        Trapezoid trapezoid1 = new Trapezoid(height, topBase, middleBase, bottomBase);
        System.out.println(trapezoid1);
        System.out.println("Area: " + trapezoid1.calculateArea());
        System.out.println();
        
        // ===== APPROACH 2: Composition =====
        System.out.println("--- Approach 2: Composition (Reuse) ---");
        TrapezoidReuse trapezoid2 = new TrapezoidReuse(height, topBase, middleBase, bottomBase);
        System.out.println("Components of the trapezoid:");
        trapezoid2.showComponents();
        System.out.println();
        
        // Calculate individual areas
        System.out.println("Individual component areas:");
        System.out.println(" Rectangle area: " + trapezoid2.getRectangle().calculateArea());
        System.out.println(" Triangle 1 area: " + trapezoid2.getTriangle1().calculateArea());
        System.out.println(" Triangle 2 area: " + trapezoid2.getTriangle2().calculateArea());
        System.out.println();
        
        System.out.println("Total area (using composition): " + trapezoid2.calculateArea());
        System.out.println();
        
        // ===== VERIFICATION =====
        System.out.println("--- Verification ---");
        System.out.println("Direct calculation area: " + trapezoid1.calculateArea());
        System.out.println("Composition area: " + trapezoid2.calculateArea());
        
        if (Math.abs(trapezoid1.calculateArea() - trapezoid2.calculateArea()) < 0.001) {
            System.out.println("[OK] Both methods produce the same result!");
        } else {
            System.out.println("[X] Results don't match - check your implementation");
        }
    }
}