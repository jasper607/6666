public class Trapezoid {
    private double height;
    private double topBase;
    private double middleBase;
    private double bottomBase;

    public Trapezoid(double height, double topBase, double middleBase, double bottomBase) {
        this.height = height;
        this.topBase = topBase;
        this.middleBase = middleBase;
        this.bottomBase = bottomBase;
    }

    public double getHeight() {
        return height;
    }

    public double getTopBase() {
        return topBase;
    }

    public double getMiddleBase() {
        return middleBase;
    }

    public double getBottomBase() {
        return bottomBase;
    }

    public double calculateArea() {
        return height * (topBase + middleBase + bottomBase) / 2;
    }

    @Override
    public String toString() {
        return "Trapezoid[height=" + height + ", topBase=" + topBase + 
               ", middleBase=" + middleBase + ", bottomBase=" + bottomBase + "]";
    }
}