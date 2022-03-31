package cn.ioucon.test1112.task01;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 *  年和月相同的为一组
 */

public class GroupComparator extends WritableComparator {
    protected GroupComparator() {
        super(OrderBean.class, true);
    }
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        OrderBean aBean = (OrderBean) a;
        OrderBean bBean = (OrderBean) b;
        if (aBean.getId() > bBean.getId()){
            return 1;
        }else if (aBean.getId() < bBean.getId()){
            return -1;
        }else {
            return 0;
        }
    }
}