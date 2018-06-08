Java通过Executors提供四种线程池，分别为：
newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。

备注：Executors只是一个工厂类，它所有的方法返回的都是ThreadPoolExecutor、ScheduledThreadPoolExecutor这两个类的实例。

ExecutorService的执行
- execute(Runnable)
- submit(Runnable)
- submit(Callable)
- invokeAny(...)
- invokeAll(...)


五、ExecutorService的关闭
当我们使用完成ExecutorService之后应该关闭它，否则它里面的线程会一直处于运行状态。
举个例子，如果的应用程序是通过main()方法启动的，在这个main()退出之后，如果应用程序中的ExecutorService没有关闭，这个应用将一直运行。
之所以会出现这种情况，是因为ExecutorService中运行的线程会阻止JVM关闭。
如果要关闭ExecutorService中执行的线程，我们可以调用ExecutorService.shutdown()方法。
在调用shutdown()方法之后，ExecutorService不会立即关闭，但是它不再接收新的任务，直到当前所有线程执行完成才会关闭，
所有在shutdown()执行之前提交的任务都会被执行。
如果我们想立即关闭ExecutorService，我们可以调用ExecutorService.shutdownNow()方法。
这个动作将跳过所有正在执行的任务和被提交还没有执行的任务。
但是它并不对正在执行的任务做任何保证，有可能它们都会停止，也有可能执行完成。

