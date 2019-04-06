package com.example.demo.test.juc.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @program: testall
 * @Date: 2019/4/3 11:32
 * @Author: mistyle
 * @Description:
 */
public class ThreadTiming {
    private int nThread;

    private CountDownLatch startGate;
    private CountDownLatch endGate;

    public ThreadTiming(int nThread, CountDownLatch startGate, CountDownLatch endGate) {

        this.nThread = nThread;
        this.startGate = startGate;
        this.endGate = endGate;
    }

    class worker implements Runnable {

        public void run() {
            try {
                startGate.await();//因为是再循环里面start所有线程，这里次数是1，
                Random random = new Random();
               // int num = random.nextInt(500) + 500; //
               long num= (long)(Math.random()*2000+3000); //500线程，5106秒，
                System.out.println(Thread.currentThread().getName() + " start and sleep: " + num + "ms");
                Thread.sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                endGate.countDown();
            }
        }
    }

    public long timeTasks() {

        for(int i = 0; i < nThread; i++){
            Thread thread = new Thread(new worker());
            thread.start();
        }

        long start = System.currentTimeMillis();
        //所有阻塞的任务同时开始
        startGate.countDown(); //所有线程都start 完成以后，再 startGate.await();
        try {
            //主线程阻塞,等待其他所有 worker 线程完成后再执行
            endGate.await();//所有线程执行完，才执行后面的，所以是5次
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("用时: " + (end - start) + "ms");

        return end - start;
    }

    public static void main(String[] args) {

        int nThread = 3;
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(nThread);

        new ThreadTiming(nThread, startGate, endGate).timeTasks();

    }

}
/**
 * 打印结果：
 * "C:\Program Files\Java\jdk1.8.0_162\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.1\lib\idea_rt.jar=56197:C:\Program Files\JetBrains\IntelliJ IDEA 2019.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_162\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_162\jre\lib\rt.jar;C:\source\idea-workspace\testall\target\classes;C:\Users\lenovo\.m2\repository\org\springframework\boot\spring-boot-starter\2.1.0.RELEASE\spring-boot-starter-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\boot\spring-boot\2.1.0.RELEASE\spring-boot-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-context\5.1.2.RELEASE\spring-context-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.1.0.RELEASE\spring-boot-autoconfigure-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.1.0.RELEASE\spring-boot-starter-logging-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\lenovo\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\lenovo\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.11.1\log4j-to-slf4j-2.11.1.jar;C:\Users\lenovo\.m2\repository\org\apache\logging\log4j\log4j-api\2.11.1\log4j-api-2.11.1.jar;C:\Users\lenovo\.m2\repository\org\slf4j\jul-to-slf4j\1.7.25\jul-to-slf4j-1.7.25.jar;C:\Users\lenovo\.m2\repository\javax\annotation\javax.annotation-api\1.3.2\javax.annotation-api-1.3.2.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-core\5.1.2.RELEASE\spring-core-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-jcl\5.1.2.RELEASE\spring-jcl-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\yaml\snakeyaml\1.23\snakeyaml-1.23.jar;C:\Users\lenovo\.m2\repository\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;C:\Users\lenovo\.m2\repository\net\bytebuddy\byte-buddy\1.9.3\byte-buddy-1.9.3.jar;C:\Users\lenovo\.m2\repository\org\springframework\boot\spring-boot-starter-web\2.1.0.RELEASE\spring-boot-starter-web-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\boot\spring-boot-starter-json\2.1.0.RELEASE\spring-boot-starter-json-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.9.7\jackson-databind-2.9.7.jar;C:\Users\lenovo\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.9.0\jackson-annotations-2.9.0.jar;C:\Users\lenovo\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.9.7\jackson-core-2.9.7.jar;C:\Users\lenovo\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.9.7\jackson-datatype-jdk8-2.9.7.jar;C:\Users\lenovo\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.9.7\jackson-datatype-jsr310-2.9.7.jar;C:\Users\lenovo\.m2\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.9.7\jackson-module-parameter-names-2.9.7.jar;C:\Users\lenovo\.m2\repository\org\springframework\boot\spring-boot-starter-tomcat\2.1.0.RELEASE\spring-boot-starter-tomcat-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\apache\tomcat\embed\tomcat-embed-core\9.0.12\tomcat-embed-core-9.0.12.jar;C:\Users\lenovo\.m2\repository\org\apache\tomcat\embed\tomcat-embed-el\9.0.12\tomcat-embed-el-9.0.12.jar;C:\Users\lenovo\.m2\repository\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.12\tomcat-embed-websocket-9.0.12.jar;C:\Users\lenovo\.m2\repository\org\hibernate\validator\hibernate-validator\6.0.13.Final\hibernate-validator-6.0.13.Final.jar;C:\Users\lenovo\.m2\repository\javax\validation\validation-api\2.0.1.Final\validation-api-2.0.1.Final.jar;C:\Users\lenovo\.m2\repository\org\jboss\logging\jboss-logging\3.3.2.Final\jboss-logging-3.3.2.Final.jar;C:\Users\lenovo\.m2\repository\com\fasterxml\classmate\1.4.0\classmate-1.4.0.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-web\5.1.2.RELEASE\spring-web-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-beans\5.1.2.RELEASE\spring-beans-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-webmvc\5.1.2.RELEASE\spring-webmvc-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-aop\5.1.2.RELEASE\spring-aop-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-expression\5.1.2.RELEASE\spring-expression-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;C:\Users\lenovo\.m2\repository\xml-apis\xml-apis\1.4.01\xml-apis-1.4.01.jar;C:\Users\lenovo\.m2\repository\jdom\jdom\1.0\jdom-1.0.jar;C:\Users\lenovo\.m2\repository\net\sf\json-lib\json-lib\2.4\json-lib-2.4-jdk15.jar;C:\Users\lenovo\.m2\repository\commons-beanutils\commons-beanutils\1.8.0\commons-beanutils-1.8.0.jar;C:\Users\lenovo\.m2\repository\commons-collections\commons-collections\3.2.1\commons-collections-3.2.1.jar;C:\Users\lenovo\.m2\repository\commons-lang\commons-lang\2.5\commons-lang-2.5.jar;C:\Users\lenovo\.m2\repository\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar;C:\Users\lenovo\.m2\repository\net\sf\ezmorph\ezmorph\1.0.6\ezmorph-1.0.6.jar;C:\Users\lenovo\.m2\repository\com\google\code\gson\gson\2.8.5\gson-2.8.5.jar;C:\Users\lenovo\.m2\repository\org\springframework\boot\spring-boot-starter-data-jpa\2.1.0.RELEASE\spring-boot-starter-data-jpa-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\boot\spring-boot-starter-aop\2.1.0.RELEASE\spring-boot-starter-aop-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\aspectj\aspectjweaver\1.9.2\aspectjweaver-1.9.2.jar;C:\Users\lenovo\.m2\repository\org\springframework\boot\spring-boot-starter-jdbc\2.1.0.RELEASE\spring-boot-starter-jdbc-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\com\zaxxer\HikariCP\3.2.0\HikariCP-3.2.0.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-jdbc\5.1.2.RELEASE\spring-jdbc-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\javax\transaction\javax.transaction-api\1.3\javax.transaction-api-1.3.jar;C:\Users\lenovo\.m2\repository\javax\xml\bind\jaxb-api\2.3.1\jaxb-api-2.3.1.jar;C:\Users\lenovo\.m2\repository\javax\activation\javax.activation-api\1.2.0\javax.activation-api-1.2.0.jar;C:\Users\lenovo\.m2\repository\org\hibernate\hibernate-core\5.3.7.Final\hibernate-core-5.3.7.Final.jar;C:\Users\lenovo\.m2\repository\javax\persistence\javax.persistence-api\2.2\javax.persistence-api-2.2.jar;C:\Users\lenovo\.m2\repository\org\javassist\javassist\3.23.1-GA\javassist-3.23.1-GA.jar;C:\Users\lenovo\.m2\repository\antlr\antlr\2.7.7\antlr-2.7.7.jar;C:\Users\lenovo\.m2\repository\org\jboss\jandex\2.0.5.Final\jandex-2.0.5.Final.jar;C:\Users\lenovo\.m2\repository\org\dom4j\dom4j\2.1.1\dom4j-2.1.1.jar;C:\Users\lenovo\.m2\repository\org\hibernate\common\hibernate-commons-annotations\5.0.4.Final\hibernate-commons-annotations-5.0.4.Final.jar;C:\Users\lenovo\.m2\repository\org\springframework\data\spring-data-jpa\2.1.2.RELEASE\spring-data-jpa-2.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\data\spring-data-commons\2.1.2.RELEASE\spring-data-commons-2.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-orm\5.1.2.RELEASE\spring-orm-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-tx\5.1.2.RELEASE\spring-tx-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-aspects\5.1.2.RELEASE\spring-aspects-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\mysql\mysql-connector-java\8.0.13\mysql-connector-java-8.0.13.jar;C:\Users\lenovo\.m2\repository\org\springframework\boot\spring-boot-starter-data-redis\2.1.0.RELEASE\spring-boot-starter-data-redis-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\data\spring-data-redis\2.1.2.RELEASE\spring-data-redis-2.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\data\spring-data-keyvalue\2.1.2.RELEASE\spring-data-keyvalue-2.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-oxm\5.1.2.RELEASE\spring-oxm-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-context-support\5.1.2.RELEASE\spring-context-support-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\redis\clients\jedis\2.9.0\jedis-2.9.0.jar;C:\Users\lenovo\.m2\repository\org\apache\commons\commons-pool2\2.6.1\commons-pool2-2.6.1.jar;C:\Users\lenovo\.m2\repository\org\springframework\boot\spring-boot-starter-amqp\2.1.0.RELEASE\spring-boot-starter-amqp-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\spring-messaging\5.1.2.RELEASE\spring-messaging-5.1.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\amqp\spring-rabbit\2.1.0.RELEASE\spring-rabbit-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\amqp\spring-amqp\2.1.0.RELEASE\spring-amqp-2.1.0.RELEASE.jar;C:\Users\lenovo\.m2\repository\org\springframework\retry\spring-retry\1.2.2.RELEASE\spring-retry-1.2.2.RELEASE.jar;C:\Users\lenovo\.m2\repository\com\rabbitmq\amqp-client\5.4.3\amqp-client-5.4.3.jar" com.example.demo.test.juc.countdownlatch.ThreadTiming
 * Thread-0 start and sleep: 669ms
 * Thread-1 start and sleep: 927ms
 * Thread-2 start and sleep: 567ms
 * Thread-3 start and sleep: 818ms
 * Thread-4 start and sleep: 789ms
 * 用时: 928ms
 *
 * 结果：最终用时比最长用时的线程稍微多一点
 *
 * 另外5个线程用时920多ms,500个线程1143秒，5万个线程12秒
 */
