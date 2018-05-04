Configuration conf = new Configuration();
Job job = Job.getInstance(conf);
job.setMapperClass(MyMapper.class);
job.setReducerClass(MyReducer.class);
job.setCombinerClass(MyCombiner.class);
job.setMapOutputKeyClass(MyMapKeyWritable.class);
job.setMapOutputValueClass(MyMapValueWritable.class);
job.setOutputKeyClass(MyKeyWritable.class);
job.setOutputValueClass(MyValueWritable.class);
job.setInputFormatClass(MyInputFormat.class);
job.setOutputFormatClass(MyOutputFormat.class);
for(int i = 0;i < args.length - 1; ++i) {
	FileInputFormat.addInputPath(job, new Path(args[i]));
}
FileOutputFormat.setOutputPath(job, new Path(args[args.length-1]));
job.waitForCompletion(true);