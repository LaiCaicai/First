package cn.ioucon.test1105;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NameBean implements WritableComparable<NameBean> {

    private String name;

    public NameBean(){
        super();
    }

    public NameBean(String name) {
        super();
        this.name = name;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeChars(name);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.name = dataInput.readLine();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ""+name;
    }

    @Override
    public int compareTo(NameBean o) {
        return 0;
    }
}
