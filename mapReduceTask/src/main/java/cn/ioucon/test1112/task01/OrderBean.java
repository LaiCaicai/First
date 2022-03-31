package cn.ioucon.test1112.task01;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class OrderBean implements WritableComparable<OrderBean> {

    private int id;
    private Double money;

    public OrderBean(){
        super();
    }

    public OrderBean(int id, Double money) {
        super();
        this.id = id;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(id);
        dataOutput.writeDouble(money);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readInt();
        this.money = dataInput.readDouble();
    }

    @Override
    public String toString() {
        return "" + id + "\t" + "\t" + money;
    }

    @Override
    public int compareTo(OrderBean orderBean) {
        if (this.id > orderBean.getId()){
            return 1;
        }else if (this.id < orderBean.getId()){
            return -1;
        }else {
            if (this.money > orderBean.getMoney()){
                return -1;
            }else if (this.money < orderBean.getMoney()){
                return 1;
            }
            return 0;
        }
    }
}
