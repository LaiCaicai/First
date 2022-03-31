package cn.ioucon.test0924.telephone;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TelephoneMapper extends Mapper<LongWritable, Text,Text,TelephoneBean> {

    TelephoneBean v = new TelephoneBean();
    Text k = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String s = value.toString();
        String[] strings = s.split(" ");
        String telephone = strings[1];
        long up = Long.parseLong(strings[4]);
        long down = Long.parseLong(strings[5]);
        long sum = up+down;

        v.setDown(down);
        v.setUp(up);
        v.setSum(sum);
    }
}
