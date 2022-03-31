package cn.ioucon.test1008.task02;

import cn.ioucon.test1008.task01.SexBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TemperMapper extends Mapper<LongWritable, Text, Text, TemperBean> {

    TemperBean v = new TemperBean();
    Text k = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1 获取一行
        String line = value.toString();
        // 2 切割字段
        // String[] fields = line.split(",");
        // 3 封装对象
        String year = line.substring(0,4);
        long temper = Integer.parseInt(line.substring(8));
        k.set(year);
        v.setTemper(temper);
        // 4 写出
        context.write(k, v);
    }
}
