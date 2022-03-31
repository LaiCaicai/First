package cn.ioucon.test1008.task02;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class TemperBean implements Writable {

    private long temper;

    public TemperBean(){
        super();
    }

    public TemperBean(long temper){
        super();
        this.temper = temper;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(temper);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.temper=dataInput.readLong();
    }

    public long getTemper() {
        return temper;
    }

    public void setTemper(long temper) {
        this.temper = temper;
    }

    @Override
    public String toString() {
        return "" + temper;
    }
}
