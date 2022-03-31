package cn.ioucon.test1022.task1;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SexMapper extends Mapper<LongWritable, Text, Text, SexBean> {

    SexBean v = new SexBean();
    Text k = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1 获取一行
        String line = value.toString();
        // 2 切割字段
        String[] fields = line.split(",");
        // 3 封装对象
        String sexType = fields[3];
        long sex=1;
        k.set(sexType);
        v.setSex(sex);
        // 4 写出
        context.write(k, v);
    }
}
