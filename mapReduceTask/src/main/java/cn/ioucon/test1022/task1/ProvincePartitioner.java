package cn.ioucon.test1022.task1;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;


public class ProvincePartitioner extends Partitioner<Text, SexBean> {

    @Override
    public int getPartition(Text text, SexBean sexBean, int i) {
        int partition = 3;
        if (text.toString().equals("男")){
            partition = 0;
        }else if(text.toString().equals("女")){
            partition = 1;
        }
        return partition;
    }
}
