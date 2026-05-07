public class Triangle {
    private double height;
    private double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }

    public double calculateArea() {
        return 0.5 * height * base;
    }

    @Override
    public String toString() {
        return "Triangle[height=" + height + ", base=" + base + "]";
    }
}