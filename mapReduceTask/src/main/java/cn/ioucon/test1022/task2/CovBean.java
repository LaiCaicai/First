package cn.ioucon.test1022.task2;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CovBean implements Writable {
    private long qz;
    private long sw;

    public CovBean(){
        super();
    }

    public CovBean(long qz, long sw) {
        super();
        this.qz = qz;
        this.sw = sw;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(qz);
        dataOutput.writeLong(sw);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.qz = dataInput.readLong();
        this.sw = dataInput.readLong();
    }

    public long getQz() {
        return qz;
    }

    public void setQz(long qz) {
        this.qz = qz;
    }

    public long getSw() {
        return sw;
    }

    public void setSw(long sw) {
        this.sw = sw;
    }

    @Override
    public String toString() {
        return qz + "\t" + sw;
    }
}
