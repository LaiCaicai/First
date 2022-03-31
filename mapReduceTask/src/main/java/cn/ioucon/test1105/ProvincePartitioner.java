package cn.ioucon.test1105;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;


public class ProvincePartitioner extends Partitioner<Text, LongWritable> {

    @Override
    public int getPartition(Text text, LongWritable longWritable, int i) {
        int partition = 3;
        if (text.toString().equals("李")){
            partition = 0;
        }else if(text.toString().equals("张")){
            partition = 1;
        }
        return partition;
    }
}
