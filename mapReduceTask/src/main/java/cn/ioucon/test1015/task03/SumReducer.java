package cn.ioucon.test1015.task03;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SumReducer extends Reducer<Text, SumBean, Text, SumBean> {

    @Override
    protected void reduce(Text key, Iterable<SumBean> values, Context context) throws IOException, InterruptedException {
        long sum = 0;
        for (SumBean sumBean : values) {
            sum += sumBean.getSum();
        }
        context.write(key,new SumBean(sum));
    }
}
