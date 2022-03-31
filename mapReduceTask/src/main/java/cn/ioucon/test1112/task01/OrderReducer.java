package cn.ioucon.test1112.task01;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class OrderReducer extends Reducer<OrderBean, Text ,IntWritable, DoubleWritable> {
    @Override
    protected void reduce(OrderBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Double sum = 0.0;
        for (Text value : values) {
            sum += key.getMoney();
        }
        context.write(new IntWritable(key.getId()),new DoubleWritable(sum));
    }
}
