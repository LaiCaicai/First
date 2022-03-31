package cn.ioucon.test1008.task02;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class TemperReducer extends Reducer<Text, TemperBean, Text, TemperBean> {
    @Override
    protected void reduce(Text key, Iterable<TemperBean> values, Context context) throws IOException, InterruptedException {
        long temper = 0;
        for (TemperBean temperBean : values) {
            temper = Math.max(temper,temperBean.getTemper());
        }
        context.write(key,new TemperBean(temper));
    }
}
