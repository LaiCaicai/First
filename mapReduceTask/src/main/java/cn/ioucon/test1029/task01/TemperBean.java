package cn.ioucon.test1029.task01;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class TemperBean implements WritableComparable<TemperBean> {

    private int year;
    private int month;
    private int day;
    private int temp;

    public TemperBean(){
        super();
    }

    public TemperBean(int year, int month, int day, int temp) {
        super();
        this.year = year;
        this.month = month;
        this.day = day;
        this.temp = temp;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(year);
        dataOutput.writeInt(month);
        dataOutput.writeInt(temp);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.year = dataInput.readInt();
        this.month = dataInput.readInt();
        this.temp = dataInput.readInt();
    }

    @Override
    public String toString() {
        return "" + year + "\t" + month + "\t" + temp;
    }

    @Override
    public int compareTo(TemperBean temperBean) {
        if (this.year > temperBean.getYear()){
            return 1;
        }else if (this.year < temperBean.getYear()){
            return -1;
        }else {
            if (this.month > temperBean.getMonth()){
                return 1;
            }else if (this.month < temperBean.getMonth()){
                return -1;
            }else {
                if (this.temp > temperBean.getTemp()){
                    return -1;
                }else if (this.temp < temperBean.getTemp()){
                    return 1;
                }
                return 0;
            }
        }
    }
}
