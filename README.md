# testall


1.juc 测试
    (1)  AtomicIntegerTest  AtomicInteger+countdownlatch+future 有条件的退出定时任务 (dcpcallback)
   (2) AtomicIntegerTest1 控制方法并发的次数，超过100，返回null
  （3）AtomicIntegerTest2   同步锁Lock,synchronized与CAS AtomicInteger对比测试
  （4）ConcurrentHashMapTest  ConcurrentHashMap与hashMap对比测试
   (5)ConcurrentHashMapDemo  ConcurrentHashMapDemo2  HashMapDemo 对比测试
   (6) NewCachedThreadPoolTest , NewFixedThreadPoolTest,NewScheduledThreadPoolTest(包括newSingleThreadScheduledExecutor),NewSingleThreadPoolTest
  
   （7）countdownlatch.TestCountDownLatch 阻塞主线程 (经典实例)
   (8)countdownlatch.CountDownLatchTest   countdownlatch+sleep,
   (9)countdownlatch.ThreadTiming  统计单个线程的执行时间以及所有线程的执行时间(重要)
   (10) BlockingQueueTest 有界队列
   
   
   
2.多线程程序测试
   (1) test.thread.sync.TestSyn 同步synchronized ,类锁与对象锁
   (1) test.thread.sync.D 对象锁与类锁，（没有同步）
    （1） test.thread.sync.C  类锁实现同步
     （2）test.thread.sync.B+test 对一个同步实现同步
   (2) test.thread.ExecutorsShutdown    Executors  最正确的关闭方式
   (3)  test.thread.ExecutorsSingleProblem  线程池不能做成单例的
   (4)  test.thread.InterrupTest   Interrup各种方法，包括异常，就看这一个
   （5）  test.thread.ThreadLocalTest   线程join操作,以及threadLocal
   （6）  test.thread.ThreadOrderTest   控制线程的执行顺序
   (7)test.thread.ThreadOrderCirceTest1,ThreadOrderCirceTest2
   子线程和主线程轮流执行，子线程执行30次，主线程执行40次，轮流执行，循环50次
   (8)  test.thread.SyncThread   synchronized同步测试，
   
   可重入锁
   (9)test.thread.ReentrantTest 可重入锁测试
   (9)  test.thread.Lock和test.thread.LockReInter,LockTest可重入锁与不可重入锁测试
   (9)  test.thread.TheadSoceDate  类锁与对象锁
    (9)  test.thread.TheadSoceDate2  threadlocal
   
   
3 .基本
    (1)test.InvokeTest 对象引用与基本类型的引用
    (2)test.change.Xml2JsonTest  xml转json
     (3)test.circleDependency  循环依赖注入测试
     (4)test.commandlinerunner  预先数据加载测试
     (5)test.http.HttpTest http请求返回json格式数据测试
     (5)test.LimiterTestApp 限速器，多长时间类接受多少个请求
 
4.单元测试
    (1) LogTest  log打印测试
    (2) ApplicationTests 增删改查 web单元测试
    (3) UserRepositoryTests  jpa保存操作(数据库测试，新的注解)
    (3) User1MapperTest  mybatis测试
   // (4) BenchMarkTest 压力测试，锁测试     2019-4-29 去掉，移到单独得工程
    //(5) com.example.demo.rabbit    rabbitmq测试     2019-4-29 去掉，移到单独得工程
    //(6) RedisTest  redis测试    2019-4-29 去掉，移到单独得工程
    (7) TableIndexTest  Executors单例问题，主线程sleep,jpa数据保存
   