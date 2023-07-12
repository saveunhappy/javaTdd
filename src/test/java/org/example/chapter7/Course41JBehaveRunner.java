//package org.example.chapter7;
//
//import org.jbehave.core.configuration.Configuration;
//import org.jbehave.core.configuration.MostUsefulConfiguration;
//import org.jbehave.core.io.CodeLocations;
//import org.jbehave.core.io.LoadFromURL;
//import org.jbehave.core.io.StoryFinder;
//import org.jbehave.core.junit.JUnitStories;
//import org.jbehave.core.reporters.FilePrintStreamFactory;
//import org.jbehave.core.reporters.Format;
//import org.jbehave.core.reporters.StoryReporterBuilder;
//import org.jbehave.core.steps.InjectableStepsFactory;
//import org.jbehave.core.steps.InstanceStepsFactory;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * 	JBehave 运行器
// *
// *
// *	每种类型的测试都需要一个运行器，JBehave中也不例外。
// *
// *	JBehave的更苛刻，要求我们必须创建一个类，用于存储运行故事所需的所有配置。
// *
// *	编写运行器代码后，启动并查看结果。
// *	@author hzweiyongqiang
// */
//public class Course41JBehaveRunner extends JUnitStories{
//
//	/**
//	 * 	设置故事文件的位置
//	 * 	这是一种标准的 Apache Ant（http://ant.apache.org/）语法。
//	 * 	这意味着包含目录 stories 及其所有子目录（ ** ）中所有扩展名为 .story 的文件。
//	 */
//	@Override
//	protected List<String> storyPaths() {
//		String path = "src/test/resources/bdd/jbehave/stories/*.story";
//		return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("").getFile(),
//										   Collections.singletonList(path),
//										   new ArrayList<String>(),
//										   "file:");
//	}
//
//	@Override
//	public Configuration configuration() {
//		return new MostUsefulConfiguration().useStoryReporterBuilder(getReporter())
//											.useStoryLoader(new LoadFromURL());
//	}
//
//	private StoryReporterBuilder getReporter() {
//		return new StoryReporterBuilder()
//			  .withPathResolver(new FilePrintStreamFactory.ResolveToSimpleName())
//			  .withDefaultFormats()
//			  .withFormats(Format.CONSOLE,Format.HTML);
//	}
//
//	/**
//	 * 	用于设置包含步骤定义的类
//	 */
//	@Override
//	public InjectableStepsFactory stepsFactory() {
//		return new InstanceStepsFactory(configuration(), new Course44JBehaveSteps());
//	}
//}
