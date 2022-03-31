package cn.ioucon.test0924.cov;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class CovReducer extends Reducer<Text, CovBean, Text, CovBean> {
    @Override
    protected void reduce(Text key, Iterable<CovBean> values, Context context) throws IOException, InterruptedException {

        long sum_qz = 0;
        long sum_sw = 0;

        for (CovBean value : values) {
            sum_qz += value.getQz();
            sum_sw += value.getSw();
        }

        CovBean covBean = new CovBean(sum_qz, sum_sw);
        context.write(key,covBean);
    }
}
