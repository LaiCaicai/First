package cn.ioucon.test0924.cov;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class CovMapper extends Mapper<LongWritable, Text, Text, CovBean> {

    CovBean v = new CovBean();
    Text k = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String string = value.toString();
        String[] strings = string.split(",");
        String city = strings[2];
        long qz = Long.parseLong(strings[4]);
        long sw = Long.parseLong(strings[5]);

        k.set(city);
        v.setQz(qz);
        v.setSw(sw);

        context.write(k, v);
    }
}
