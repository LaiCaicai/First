package cn.ioucon.test1105;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class NameMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

    Text k = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1 获取一行
        String line = value.toString();
        // 2 切割字段
        String[] fields = line.split("，");
        // 3 封装对象
        for (String field : fields) {
            char c = field.charAt(0);
            if (c=='张' || c=='李'){
                k.set(String.valueOf(c));
                context.write(k, new LongWritable(1));
            }
        }
    }
}
