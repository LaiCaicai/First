package cn.ioucon.test1008.task01;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class SexBean implements Writable {

    private long sex;

    public SexBean(){
        super();
    }

    public SexBean(long sex) {
        super();
        this.sex = sex;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(sex);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.sex = dataInput.readLong();
    }

    public long getSex() {
        return sex;
    }

    public void setSex(long sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return ""+sex;
    }
}
