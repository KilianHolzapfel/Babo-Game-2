package client.entities;

public class Angle {
    // winkel im Bogenmaﬂ (radians)
    private double angle;
    
    public Angle(double angle){
        this.angle = angle;
    }
    
    public Angle(){
        
    }
    
    public Angle(double angle, boolean radians){
        if (radians){
            this.angle = angle;
        } else {
            setDegrees(angle);
        }
    }
    
    public void set(double angle){
        this.angle = angle;
    }
    
    /**
     * 
     * @return the angle as Radians
     */
    public double get(){
        return angle;
    }
    
    public void add(Angle angle){
        add(angle.get());
    }
    
    public void add(double angle){
        this.angle += angle;
        if (this.angle < 0){
            this.angle += Math.PI * 2.0 * (-this.angle / (2.0 * Math.PI) + 1);
        }
        this.angle %= Math.PI * 2;
    }
    
    public double getAsDegrees(){
        return Math.toDegrees(angle);
    }
    
    public double getAsRadians(){
        return angle;
    }
    
    public void setDegrees(double degree){
        this.angle = Math.toRadians(degree);
    }
    
    public void setRadians(double radian){
        this.angle = radian;
    }
}
