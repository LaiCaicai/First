package cn.ioucon.test1029.task01;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class SortComparator extends WritableComparator {
    protected SortComparator() {
        super(TemperBean.class, true);
    }
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        TemperBean aBean = (TemperBean) a;
        TemperBean bBean = (TemperBean) b;
        if (aBean.getYear() > bBean.getYear()){
            return 1;
        }else if (aBean.getYear() < bBean.getYear()){
            return -1;
        }else {
            if (aBean.getMonth() > bBean.getMonth()){
                return 1;
            }else if (aBean.getMonth() < bBean.getMonth()){
                return -1;
            }else {
                if (aBean.getTemp() > bBean.getTemp()){
                    return -1;
                }else if (aBean.getTemp() < bBean.getTemp()){
                    return 1;
                }
                return 0;
            }
        }
    }
}