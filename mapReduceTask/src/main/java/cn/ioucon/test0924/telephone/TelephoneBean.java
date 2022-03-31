package cn.ioucon.test0924.telephone;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class TelephoneBean implements Writable {
    private long up;
    private long down;
    private long sum;

    public TelephoneBean(){
        super();
    }

    public TelephoneBean(long up, long down) {
        super();
        this.up = up;
        this.down = down;
        this.sum = up+down;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(up);
        dataOutput.writeLong(down);
        dataOutput.writeLong(sum);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }

    public long getUp() {
        return up;
    }

    public void setUp(long up) {
        this.up = up;
    }

    public long getDown() {
        return down;
    }

    public void setDown(long down) {
        this.down = down;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "TelephoneBean{" +
                "up=" + up +
                ", down=" + down +
                ", sum=" + sum +
                '}';
    }
}
