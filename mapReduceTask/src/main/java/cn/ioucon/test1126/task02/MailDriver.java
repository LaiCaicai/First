package cn.ioucon.test1126.task02;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.net.URI;

public class MailDriver {
    public static void main(String[] args) throws Exception {
// 0 根据自己电脑路径重新配置
        args = new String[]{"F:\\mapreduce-and-spark-master\\mapreduce\\mapReduceTask\\src\\main\\resources\\test1126\\input\\email.txt", "F:\\mapreduce-and-spark-master\\mapreduce\\mapReduceTask\\src\\main\\resources\\test1126\\input\\out"};
// 1 获取 job 信息
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
// 2 设置加载 jar 包路径
        job.setJarByClass(MailDriver.class);
// 3 关联 map
        job.setMapperClass(MailMapper.class);
// 4 设置最终输出数据类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
// 5 设置输入输出路径
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
// 6 加载缓存数据
        job.addCacheFile(new URI("file:///F:/mapreduce-and-spark-master/mapreduce/mapReduceTask/src/main/resources/test1126/input/pd.txt"));
// 7 Map 端 Join 的逻辑不需要 Reduce 阶段，设置 reduceTask 数量为 0
        job.setNumReduceTasks(0);
// 8 提交
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
