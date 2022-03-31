package cn.ioucon.test1112.task01;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OrderMapper extends Mapper<LongWritable, Text, OrderBean,Text> {

    OrderBean k = new OrderBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1 获取一行
        String line = value.toString();
        // 2 切割字段
        String[] fields = line.split("\t");
        // 3 封装对象
        int id = Integer.parseInt(fields[0]);
        double money = Double.parseDouble(fields[2]);
        k.setId(id);
        k.setMoney(money);
        // 4 写出
        context.write(k,value);
    }
}
