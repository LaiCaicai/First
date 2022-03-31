package cn.ioucon.test0924.telephone;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class TelephoneDriver {
    public static void main(String[] args) throws IllegalArgumentException, IOException, ClassNotFoundException, InterruptedException {
// 输入输出路径需要根据自己电脑上实际的输入输出路径设置
        args = new String[] { "D:\\ProgramData\\hadoop\\demo20210910\\src\\main\\resources\\flowcount\\input\\flowcount.txt", "D:\\ProgramData\\hadoop\\demo20210910\\src\\main\\resources\\flowcount\\output" };
// 1 获取配置信息，或者 job 对象实例
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
// 6 指定本程序的 jar 包所在的本地路径
        job.setJarByClass(TelephoneDriver.class);
// 2 指定本业务 job 要使用的 mapper/Reducer 业务类
        job.setMapperClass(TelephoneMapper.class);
        job.setReducerClass(TelephoneReducer.class);
// 3 指定 mapper 输出数据的 kv 类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(TelephoneBean.class);
// 4 指定最终输出的数据的 kv 类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(TelephoneBean.class);
// 5 指定 job 的输入原始文件所在目录
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
// 7 将 job 中配置的相关参数，以及 job 所用的 java 类所在的 jar包， 提交给 yarn 去运行
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
