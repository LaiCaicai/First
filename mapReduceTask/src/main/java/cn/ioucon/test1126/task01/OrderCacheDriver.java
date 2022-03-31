package cn.ioucon.test1126.task01;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.net.URI;

public class OrderCacheDriver {
    public static void main(String[] args) throws Exception {
// 0 根据自己电脑路径重新配置
        args = new String[]{"F:/software/MapReduce/projects/mapReduceTask/src/main/resources/test1126/input/order.txt",
                "F:/software/MapReduce/projects/mapReduceTask/src/main/resources/test1126/input/output"};
// 1 获取 job 信息
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
// 2 设置加载 jar 包路径
        job.setJarByClass(OrderCacheDriver.class);
// 3 关联 map
        job.setMapperClass(OrderCacheMapper.class);
// 4 设置最终输出数据类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        //Map端表合并案例分析（Distributedcache） 1）DistributedCacheDriver 缓存文件
// 1 加载缓存数据
        job.addCacheFile(new URI("file:///F:/software/MapReduce/projects/mapReduceTask/src/main/resources/test1126/input/pd.txt"));
//2 Map 端 join 的逻辑不 需 要Reduce阶 段，设 置ReduceTask数量为0
        job.setNumReduceTasks(0); //读取缓存的文件数据setup()方法中
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
// 7 Map 端 Join 的逻辑不需要 Reduce 阶段，设置 reduceTask 量为 0
// 8 提交
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}

