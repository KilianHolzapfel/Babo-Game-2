package client.entities;

public class Position {
    public static final byte FIX_ON_SCREEN = 0;
    public static final byte FIX_ON_MAP = 1;
    public static final byte MOVING_ON_SCREEN = 2;
    public static final byte MOVING_ON_MAP = 3;
    
    private Point point;
    
    private final byte type;
    
    public Position(byte type){
        this.type = type;
    }
    
    public Position(byte type, double x, double y){
        this.type = type;
    }
    
    public void setPosition(Position position){
        point.setPosition(position);
    }
    
    public void setPosition(double x, double y){
        point.set(x, y);
    }
    
    public void setX(double x){
        point.setX(x);
    }
    
    public void setY(double y){
        point.setY(y);
    }
    
    public double x(){
        return point.x();
    }
    
    public double y(){
        return point.y();
    }
    
    public void add(Point point){
        this.point.add(point);
    }
    
    public void addX(double x){
        point.addX(x);
    }
    
    public void addY(double y){
        point.addY(y);
    }
    
    public Point getAsPoint(){
        return point;
    }
    
    public int getType(){
        return type;
    }
    
    @Override
    public String toString(){
        String type = null;
        switch(this.type){
        case FIX_ON_SCREEN:
            type = "FIX_ON_SCREEN";
            break;
        case FIX_ON_MAP:
            type = "FIX_ON_MAP";
            break;
        case MOVING_ON_SCREEN:
            type = "MOVING_ON_SCREEN";
            break;
        case MOVING_ON_MAP:
            type = "MOVING_ON_MAP";
            break;
        }
        return "Position(" + type + ", " + point.x() + ", " + point.y() + ")";
    }
}
