package cn.ioucon.test1029.task01;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class TemperReducer extends Reducer< TemperBean,IntWritable, TemperBean, NullWritable> {
    @Override
    protected void reduce(TemperBean key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int i = 0;
        for (IntWritable value : values) {
            i++;
            context.write(key,NullWritable.get());
            // 任务二: 取前三列
            if (i==2){
                break;
            }
        }
    }
}
