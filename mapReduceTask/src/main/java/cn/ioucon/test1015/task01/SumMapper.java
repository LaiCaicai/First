package cn.ioucon.test1015.task01;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SumMapper extends Mapper<LongWritable, Text, Text, SumBean> {

    SumBean v = new SumBean();
    Text k = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1 获取一行
        String line = value.toString();
        // 2 切割字段
        String[] fields = line.split(",");
        // 3 封装对象
        String sumP = "总人数";
        long sum=1;
        k.set(sumP);
        v.setSum(sum);
        // 4 写出
        context.write(k, v);
    }
}
