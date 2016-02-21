package client.entities;

public class Vector {
    private double x;
    private double y;
    
    public Vector(){
        
    }
    
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public void setValue(Vector value){
        this.x = value.getX();
        this.y = value.getY();
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public void setValue(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public void add(Vector vector){
        this.x += vector.getX();
        this.y += vector.getY();
    }
    
    public void mult(double factor){
        this.x *= factor;
        this.y *= factor;
    }
    
    public void rotate(Angle angle){
        double x = Math.cos(angle.get()) * this.x - Math.sin(angle.get()) * this.y;
        this.y = Math.sin(angle.get()) * this.x + Math.cos(angle.get()) * this.y;
        this.x = x;
    }
    
    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }
    
    public static void main(String[] args){
        Vector vektor = new Vector(0, 1);
        Angle angle = new Angle(45, false);
        vektor.rotate(angle);
        vektor.normalize();
        System.out.println(vektor);
    }
    
    public void normalize(){
        double length = Math.sqrt(x * x + y * y);
        x = x / length;
        y = y / length;
    }
}
