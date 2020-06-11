package StreamDemo;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author CRC
 * @Date 2020/6/1
 * @Describe stream流API练习
 */
public class Demo {
    public static void main(String[] args) {
        List<User> stream = createPojo();

        filterDemo(stream);
        sortedDemo(stream);
        distinctDemo(stream);
        limitDemo(stream);
        skipDemo(stream);
        mapDemo(stream);

        flatMapDemo();
        allMatchDemo(stream);
        anyMatchDemo(stream);
        noneMatchDemo(stream);
        findFirstDemo(stream);
        findAnyDemo(stream);
        countDemo(stream);
        max_min(stream);
        sum_avg(stream);
        allVlaue(stream);
        join(stream);
        group(stream);
        groupCount(stream);
        partitioningBy(stream);

        //双冒号测试
//        doubleMaoHao();
    }

    /**
     * 双冒号测试
     */
    public static void doubleMaoHao(){
        List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");
        //静态方法语法	ClassName::methodName
        list.forEach(Demo::print);
    }
    public static void print(String content) {
        System.out.println("双冒号测试结果 --> "+content);
    }

    /**
     * 过滤
     *
     * @param stream
     * @return
     */
    public static void filterDemo(List<User> stream) {
        List<User> filterDemo = stream.stream()
                .filter(user -> user.getAge() > 18)
                .filter(user -> user.getAge() < 50)
                .collect(Collectors.toList());
        System.out.println("过滤-->" + filterDemo);
    }

    /**
     * 排序
     *
     * @param stream
     * @return
     */
    public static void sortedDemo(List<User> stream) {
        List<User> sortedDemo = stream.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
        System.out.println("排序-->" + sortedDemo);
    }

    /**
     * 去重
     *
     * @param stream
     * @return
     */
    public static void distinctDemo(List<User> stream) {
        List<User> distinctDemo = stream.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("去重-->" + distinctDemo);
    }

    /**
     * 获取前N个值
     *
     * @param stream
     * @return
     */
    public static void limitDemo(List<User> stream) {
        List<User> limitDemo = stream.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("取前N个值-->" + limitDemo);
    }

    /**
     * 去除前N个值
     *
     * @param stream
     * @return
     */
    public static void skipDemo(List<User> stream) {
        List<User> skipDemo = stream.stream()
                .skip(5)
                .collect(Collectors.toList());
        System.out.println("去除前N个值-->" + skipDemo);
    }

    /**
     * 返回新的map
     *
     * @param stream
     * @return
     */
    public static void mapDemo(List<User> stream) {
        List<String> mapDemo = stream.stream()
                .distinct()
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println("返回新的map-->" + mapDemo);
    }

    /**
     * 把集合的值分开做分割再组合
     *
     * @return
     */
    public static void flatMapDemo() {
        List<String> flatmap = new ArrayList<>();
        flatmap.add("常宣灵,常昊灵");
        flatmap.add("孟婆,判官红,判官蓝");
        List<String> result = flatmap.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println("flatMapDemo测试结果--> " + result);
    }

    /**
     * 判断所有元素是否符合条件
     *
     * @param stream
     */
    public static void allMatchDemo(List<User> stream) {
        boolean b = stream.stream().allMatch(user -> user.getAge() > 18);
        System.out.println("allMatch测试结果--> " + b);
    }

    /**
     * 判断是否有元素符合条件
     *
     * @param stream
     */
    public static void anyMatchDemo(List<User> stream) {
        boolean b = stream.stream().anyMatch(user -> user.getSex() == 0);
        System.out.println("anyMatchDemo测试结果--> " + b);
    }

    /**
     * 判断是否没有符合条件元素
     * 无 true
     * 有 false
     *
     * @param stream
     */
    public static void noneMatchDemo(List<User> stream) {
        boolean b = stream.stream()
                .noneMatch(user -> user.getAddress().contains("郑州"));
        System.out.println("noneMatch测试结果--> " + b);
    }

    /**
     * 获取第一个元素
     *
     * @param stream
     */
    public static void findFirstDemo(List<User> stream) {
        Optional<User> first = stream.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .findFirst();
        System.out.println("noneMatch测试结果--> " + first);
    }


    public static void findAnyDemo(List<User> stream) {
        Optional<User> optionalUser = stream.stream().findAny();
        System.out.println("findAnyDemo测试结果--> " + optionalUser.toString());
    }

    /**
     * 元素数量
     * @param stream
     */
    public static void countDemo(List<User> stream){
        long count = stream.stream().count();
        System.out.println("countDemo测试结果--> "+count);
    }

    /**
     * 最大值最小值
     * @param stream
     */
    public static void max_min(List<User> stream){
        Optional<User> max = stream.stream()
                .collect(
                        Collectors.maxBy(
                                Comparator.comparing(User::getAge)
                        )
                );
        Optional<User> min = stream.stream()
                .collect(
                        Collectors.minBy(
                                Comparator.comparing(User::getAge)
                        )
                );
        System.out.println("max_min测试结果  max--> " + max+"  min--> "+ min);
    }

    /**
     * 求和_平均值
     * @param stream
     */
    public static void sum_avg(List<User> stream){
        System.out.println("sum_avg---->");
        int totalAge = stream.stream()
                .collect(Collectors.summingInt(User::getAge));
        System.out.println("totalAge--> "+ totalAge);

        /*获得列表对象金额， 使用reduce聚合函数,实现累加器*/
        BigDecimal totalMpney = stream.stream()
                .map(User::getMoney)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("totalMpney--> " + totalMpney);

        double avgAge = stream.stream()
                .collect(Collectors.averagingInt(User::getAge));
        System.out.println("avgAge--> " + avgAge);
    }

    /**
     * 一次性得到元素的个数、总和、最大值、最小值
     * @param stream
     */
    public static void allVlaue(List<User> stream){
        System.out.println("allVlaue测试结果--->");
        IntSummaryStatistics statistics = stream.stream()
                .collect(Collectors.summarizingInt(User::getAge));
        System.out.println(statistics);
    }

    /**
     * 拼接
     * @param stream
     */
    public static void join(List<User> stream){
        String names = stream.stream()
                .map(User::getName)
                .collect(Collectors.joining(", "));
        System.out.println("join测试结果---> "+names);
    }

    /**
     * 分组
     * @param stream
     */
    public static void group(List<User> stream){
        System.out.println("group测试结果---->");
        Map<Integer, List<User>> map = stream.stream()
                .collect(Collectors.groupingBy(User::getSex));
        System.out.println(map);
//        System.out.println(new Gson().toJson(map));
        System.out.println();
        Map<Integer, Map<Integer,List<User>>> map2 = stream.stream()
                .collect(Collectors.groupingBy(User::getSex,
                        Collectors.groupingBy(User::getAge)));
        System.out.println(map2);
//        System.out.println(new Gson().toJson(map2));
    }

    /**
     * 分组合计
     * @param stream
     */
    public static void groupCount(List<User> stream){
        System.out.println("groupCount测试结果--->");
        Map<Integer, Long> num = stream.stream()
                .collect(Collectors.groupingBy(User::getSex, Collectors.counting()));
        System.out.println(num);


        Map<Integer, Long> num2 = stream.stream()
                .filter(user -> user.getAge()>=18)
                .collect(Collectors.groupingBy(User::getSex, Collectors.counting()));
        System.out.println(num2);
    }

    /**
     * 分区
     * @param stream
     */
    public static void partitioningBy(List<User> stream){
        Map<Boolean, List<User>> part = stream.stream()
                .collect(Collectors.partitioningBy(user -> user.getAge() <= 30));
        System.out.println("partitioningBy测试结果---> "+part);
//        System.out.println(new Gson().toJson(part));
    }


    /**
     * 创建集合
     *
     * @return
     */
    public static List<User> createPojo() {
        List<User> list = Arrays.asList(
                new User("李星云", 18, 0, "渝州", new BigDecimal(1000)),
                new User("陆林轩", 16, 0, "渝州", new BigDecimal(500)),
                new User("姬如雪", 17, 1, "幻音坊", new BigDecimal(800)),
                new User("袁天罡", 99, 0, "藏兵谷", new BigDecimal(100000)),
                new User("张子凡", 19, 0, "天师府", new BigDecimal(900)),
                new User("陆佑劫", 45, 1, "不良人", new BigDecimal(600)),
                new User("张天师", 48, 0, "天师府", new BigDecimal(1100)),
                new User("蚩梦", 18, 0, "万毒窟", new BigDecimal(800))
        );
        return list;
    }

    public void printDemo() {
        System.out.println("调用printDemo()");
    }
}
