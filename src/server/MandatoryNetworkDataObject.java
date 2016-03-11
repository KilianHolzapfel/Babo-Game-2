package server;

import java.nio.*;

public class MandatoryNetworkDataObject {

    // this is all data we need to send every cycle
    private int dummy;

    // which of the data was set already?
    private boolean dummySet = false;
    
    private static final int INT = 4;
    private static final int DOUBLE = 8;
    private static final int BOOLEAN = 1;
    private static final int LONG = 8;
    
    public MandatoryNetworkDataObject(byte[] array){
        setFromByteArray(array);
    }

    // set dummy data
    public void setDummy(int dummy) {
        this.dummy = dummy;
        dummySet = true;
    }
    
    public int getDummy(){
        return dummy;
    }

    // set all data
    public void set(int dummy) {
        setDummy(dummy);
    }

    // the data was sent and now we remove everything, so that we can fill the object with
    // new data for the next cycle
    public void clear() {
        dummySet = false;
    }
    
    private void checkAllDataSet(){
        if (!dummySet){
            // TODO
            // throw new NetworkDataIncompleteException();
        }
    }

    // get all data as bytestream
    public byte[] toByteArray() {
        checkAllDataSet();
        Integer currentIndex = 0;
        byte[] array = new byte[4];
        addToByteArray(dummy, array, currentIndex);
        return array;
    }
    
    private void addToByteArray(int value, byte[] array, Integer currentIndex){
        copyArrayInArray(intToByteArray(value), array, currentIndex);
    }
    
    private void addToByteArray(double value, byte[] array, Integer currentIndex){
        copyArrayInArray(doubleToByteArray(value), array, currentIndex);
    }
    
    private void addToByteArray(long value, byte[] array, Integer currentIndex){
        copyArrayInArray(longToByteArray(value), array, currentIndex);
    }
    
    private void addToByteArray(boolean value, byte[] array, Integer currentIndex){
        copyArrayInArray(booleanToByteArray(value), array, currentIndex);
    }
    
    public static byte[] doubleToByteArray(double dbl){
        byte[] array = new byte[DOUBLE];
        ByteBuffer.wrap(array).putDouble(dbl);
        return array;
    }
    
    public static double byteArrayToDouble(byte[] array){
        return ByteBuffer.wrap(array).getDouble();
    }
    
    public static byte[] intToByteArray(int integer){
        byte[] array = new byte[INT];
        ByteBuffer.wrap(array).putInt(integer);
        return array;
    }
    
    public static int byteArrayToInt(byte[] array){
        return ByteBuffer.wrap(array).getInt();
    }
    
    public static byte[] longToByteArray(long value){
        byte[] array = new byte[LONG];
        ByteBuffer.wrap(array).putLong(value);
        return array;
    }
    
    public static long byteArrayToLong(byte[] array){
        return ByteBuffer.wrap(array).getLong();
    }
    
    public static byte[] booleanToByteArray(boolean value){
        byte[] array = new byte[BOOLEAN];
        if (value){
            array[0] = 1;
        } else {
            array[0] = 0;
        }
        return array;
    }
    
    public static boolean byteArrayToBoolean(byte[] array){
        return array[0] > 0;
    }
    
    private void copyArrayInArray(byte[] from, byte[] to, Integer currentIndex){
        for (int i = 0; i < from.length; i++){
            to[currentIndex++] = from[i];
        }
    }
    
    public byte[] getNextAsArray(byte[] array, Integer currentIndex, int dataType){
        byte[] result = new byte[dataType];
        for (int i = 0; i < result.length; i++){
            result[i] = array[currentIndex++];
        }
        return result;
    }
    
    public void setFromByteArray(byte[] array){
        Integer currentIndex = 0;
        dummy = byteArrayToInt(getNextAsArray(array, currentIndex, INT));
    }
}
