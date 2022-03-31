package cn.ioucon.test1029.task01;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TemperMapper extends Mapper<LongWritable, Text, TemperBean, IntWritable> {

    TemperBean k = new TemperBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1 获取一行
        String line = value.toString();
        // 2 切割字段
        String[] fields = line.split("\t\t");
        // 3 封装对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
        try {
            Date date = simpleDateFormat.parse(fields[0]);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH)+1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int temp = Integer.parseInt(fields[1].split("c")[0]);
            k.setYear(year);
            k.setMonth(month);
            k.setDay(day);
            k.setTemp(temp);
            // 4 写出
            context.write(k, new IntWritable(temp));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
