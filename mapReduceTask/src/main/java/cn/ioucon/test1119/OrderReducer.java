package cn.ioucon.test1119;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;

public class OrderReducer extends Reducer<Text, OrderBean,
        OrderBean, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<OrderBean> values, Context context) throws IOException, InterruptedException {
        // 1 准备存储订单的集合
        ArrayList<OrderBean> orderBeans = new ArrayList<OrderBean>();
        // 2 准备 bean 对象
        OrderBean pdBean = new OrderBean();
        for (OrderBean bean : values) {
            if ("order".equals(bean.getFlag())) {// 订单表
                // 拷贝传递过来的每条订单数据到集合中
                OrderBean orderBean = new OrderBean();
                try {
                    BeanUtils.copyProperties(orderBean, bean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                orderBeans.add(orderBean);
            } else {// 产品表
                try {
                    // 拷贝传递过来的产品表到内存中
                    BeanUtils.copyProperties(pdBean, bean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // 3 表的拼接
        for(OrderBean bean:orderBeans){
            bean.setPname (pdBean.getPname());
            // 4 数据写出去
            context.write(bean, NullWritable.get());
        }
    }
}