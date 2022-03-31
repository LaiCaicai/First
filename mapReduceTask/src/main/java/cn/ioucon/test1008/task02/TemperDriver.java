package cn.ioucon.test1008.task02;

import cn.ioucon.test1008.task01.SexBean;
import cn.ioucon.test1008.task01.SexMapper;
import cn.ioucon.test1008.task01.SexReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class TemperDriver {
    public static void main(String[] args) throws IllegalArgumentException, IOException, ClassNotFoundException, InterruptedException {
        // 输入输出路径需要根据自己电脑上实际的输入输出路径设置
        args = new String[] { "D:\\ProgramData\\hadoop\\demo20210910\\src\\main\\resources\\test1008\\task02\\input\\temperature.txt", "D:\\ProgramData\\hadoop\\demo20210910\\src\\main\\resources\\test1008\\task02\\output" };
        // 1 获取配置信息，或者 job 对象实例
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        // 6 指定本程序的 jar 包所在的本地路径
        job.setJarByClass(cn.ioucon.test1008.task02.TemperDriver.class);
        // 2 指定本业务 job 要使用的 mapper/Reducer 业务类
        job.setMapperClass(TemperMapper.class);
        job.setReducerClass(TemperReducer.class);
        // 3 指定 mapper 输出数据的 kv 类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(TemperBean.class);
        // 4 指定最终输出的数据的 kv 类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(TemperBean.class);
        // 5 指定 job 的输入原始文件所在目录
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        // 7 将 job 中配置的相关参数，以及 job 所用的 java 类所在的 jar包， 提交给 yarn 去运行
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
