package cn.ioucon.test1022.task2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;


public class ProvincePartitioner extends Partitioner<Text, CovBean> {

    @Override
    public int getPartition(Text text, CovBean covBean, int i) {
        int partition = 6;
        if (text.toString().equals("Washington")){
            partition = 0;
        }else if(text.toString().equals("Illinois")){
            partition = 1;
        }else if(text.toString().equals("California")){
            partition = 2;
        }else if(text.toString().equals("Arizona")){
            partition = 3;
        }else if(text.toString().equals("North Carolina")){
            partition = 4;
        }else {
            partition = 5;
        }
        return partition;
    }
}
