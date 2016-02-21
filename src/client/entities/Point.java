package client.entities;

public class Point {
    private double x;
    private double y;
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double x(){
        return x;
    }
    
    public double y(){
        return y;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public void setPosition(Position position){
        x = position.x();
        y = position.y();
    }
    
    public void set(Point point){
        x = point.x();
        y = point.y();
    }
    
    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public void add(Point point){
        x += point.x();
        y += point.y();
    }
    
    public void addX(double x){
        this.x += x;
    }
    
    public void addY(double y){
        this.y += y;
    }
    
    @Override
    public String toString(){
        return "Point(" + x + ", " + y + ")";
    }
}
