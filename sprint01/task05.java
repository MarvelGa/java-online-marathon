public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int [] getXYPair(){
        int [] intArray = new int []{x,y};
        return intArray;
    }

    public double distance(int x, int y){
        return (double) Math.sqrt((x - this.x)*(x - this.x) + (y - this.y)*(y - this.y));
    }

    public double distance(Point point){
        double dx = this.x - point.x;
        double dy = this.y - point.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double distance(){
        return (double) Math.sqrt(this.x*this.x + this.y*this.y);
    }
}
