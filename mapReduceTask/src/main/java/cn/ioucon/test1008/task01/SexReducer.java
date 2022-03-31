package cn.ioucon.test1008.task01;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SexReducer extends Reducer<Text, SexBean, Text, SexBean> {

    @Override
    protected void reduce(Text key, Iterable<SexBean> values, Context context) throws IOException, InterruptedException {
        long sex = 0;
        for (SexBean sexBean : values) {
            sex += sexBean.getSex();
        }
        context.write(key,new SexBean(sex));
    }
}
