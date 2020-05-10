package view.ghostcloud;

import java.util.*;

import static java.util.Collections.*;

/**
 * ## 2. 模拟
 *
 * 高速公路入口有5个收费口, 3个ETC口, 1个人工口(Manual), 1个ETC/人工混合口(Mix).
 * ETC车辆在收费口的通过时间是10-20分钟(程序内模拟时间), 人工车辆在收费口的通过时间是15-25分钟(程序内模拟时间).
 * 前面车辆未放行时, 后面车辆会依次在收费口外排队.
 * 每一个新到收费站的车辆, 都会选择到时间最短的队伍后面进行排队.
 *
 * 要求写出模拟程序, 模拟60分钟(程序内模拟时间)内, 30辆ETC车和10辆人工车到达和通过收费口的场景, 模拟程序运行时长在15~40秒(真实时间)左右, 并达到如下效果:
 *
 * > 0) 60分钟(程序内模拟时间)内, 40辆车, 到达时间完全随机, 且每1分钟至多只有1辆车到达. 比如整个程序模拟车辆到达时间范围是[0, 60], 对于任意一个程序模拟时间n, 0 <= n < 60, 在[n, n+1)这个区间范围内, 只能有一辆车到达.
 * > 1) 车辆通过收费口的时间在各个类型(ETC或人工)的时间范围内完全随机.
 * > 2) 参见下图, 在右侧区域左边输出车辆的车辆编号, 到达时间, 车辆类型, 和排队的窗口, 在右侧区域右边输出车辆的车辆编号, 车辆类型, 排队窗口, 到达和离开时间.
 * > 3) (选做) 参加下图左侧区域, 绘制图形界面模拟该场景. 界面可以选用任意自己擅长的来进行绘制, Web浏览器, Swing, Qt, MFC等等都可以.
 *
 * 因为不会绘图，选做我就先忽视了
 */
public class Two2 {

    private static final LinkedList<Car> etc0 = new LinkedList<>();
    private static final LinkedList<Car> etc1 = new LinkedList<>();
    private static final LinkedList<Car> etc2 = new LinkedList<>();
    private static final LinkedList<Car> mix = new LinkedList<>();
    private static final LinkedList<Car> manual = new LinkedList<>();

    private static final ArrayList<Lane> etcLaneList = new ArrayList<>();
    private static final ArrayList<Lane> manualLaneList = new ArrayList<>();

    //1表示该时间段要生产 0表示不生产
    private static final int[] car_in_flag = new int[60];
    //单位时间 调整这个数值可以调整整体运行时间
    private static final int unit_time = 100;
    //开始时间
    private static long start_time = 0;
    //要排队的etc车数量
    private static int etc_car_num = 30;
    //要排队的人工车数量
    private static int human_car_num = 10;
    private static final Random rand = new Random();

    private class Lane implements Comparable{
        private String name;
        private String type;
        private LinkedList<Car> list;

        public Lane(String name, String type, LinkedList<Car> list) {
            this.name = name;
            this.type = type;
            this.list = list;
        }

        public LinkedList<Car> getList() {
            return list;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        //如果要进入这个通道的开始接受收费站服务的时间
        public int getStartPassTime(){
            synchronized (list){
                if(list.isEmpty()){
                    return (int)(System.currentTimeMillis()-start_time)/unit_time;
                }else{
                    Car car = list.getLast();
                    return (int)car.getLeaveTime();
                }
            }
        }

        public void addCar(Car car){
            synchronized (list){
                list.addLast(car);
            }
        }

        @Override
        public int compareTo(Object o) {
            Lane lane = (Lane) o;
            if(this.getStartPassTime() > lane.getStartPassTime()){
                return 1;
            }else{
                return -1;
            }
        }
    }

    //表示汽车
    private class Car{
        //车的名字
        private String name;
        //车的类型 0 etc 1 人工
        private int type;
        //到达时间
        private int arriveTime;
        //离开时间
        private int leaveTime;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getArriveTime() {
            return arriveTime;
        }

        public void setArriveTime(int arriveTime) {
            this.arriveTime = arriveTime;
        }

        public int getLeaveTime() {
            return leaveTime;
        }

        public void setLeaveTime(int leaveTime) {
            this.leaveTime = leaveTime;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }


    private class CarCustomer implements Runnable{

        private Lane lane;

        public CarCustomer(Lane lane) {
            this.lane = lane;
        }

        public Lane getLane() {
            return lane;
        }

        @Override
        public void run() {
            while(true){
                //因为之前对数组下标加1处理 这里也要加1
                int now = (int)(System.currentTimeMillis()-start_time)/unit_time + 1;
                synchronized (lane){
                    if(this.getLane().getList().size()>0){
                        Car car = this.getLane().getList().get(0);
                        if(car.getLeaveTime() <= now){
                            System.out.println("                                                   "+
                                    car.getName()+" --> "+lane.getName()+"-"+lane.getType()+", Duration: "+ car.getArriveTime() + " ~ " + car.getLeaveTime());
                            this.getLane().getList().removeFirst();
                        }
                    }
                    if(now > 60 && this.getLane().getList().size()<1){
//                        System.out.println("收费通道"+" --> "+lane.getName()+"-"+lane.getType()+" 结束");
                        break;
                    }
                }
            }
        }
    }


    private class CarPusher implements Runnable{

        @Override
        public void run() {
            int carNo = 1;
            while(etc_car_num > 0 || human_car_num > 0){
                //判断这个时间段是否生产过车辆
                long inTime = System.currentTimeMillis();
                int flagIndex = (int)(inTime - start_time)/unit_time;
                if(flagIndex >= 60){
                    break;
                }
                if(car_in_flag[flagIndex] == 1){
                    //不生产
                    continue;
                }
                //设置为生产过
                car_in_flag[flagIndex] = 1;
                //1表示将要生产etc车辆
                int etc_flag = 1;
                if(etc_car_num > 0 && human_car_num > 0){
                    //如果同时大于0 随意选择车辆
                    etc_flag = rand.nextInt(2);
                }else if (etc_car_num == 0){
                    //etc车辆生产完了 生产人工车辆
                    etc_flag = 0;
                }
                Car car = new Car();
                car.setName("car"+carNo++);
                //flagIndex是数组下标0-59 所以加1处理
                if(etc_flag == 1){
                    car.setType(0);
                    car.setArriveTime(flagIndex+1);
                    etc_car_num--;
                }else{
                    car.setType(1);
                    car.setArriveTime(flagIndex+1);
                    human_car_num--;
                }
                pushCar(car);
            }
        }
    }

    //把车辆放到合适的列表
    public static void pushCar(Car car){
        Lane lane;
        if(car.getType() == 0){
            //etc车辆通行时间10-20个单位
            sort(etcLaneList);
            lane = etcLaneList.get(0);
            //离开时间等于开始接受收费站服务的时间 加上 通行时间
            car.setLeaveTime(lane.getStartPassTime()+rand.nextInt(11)+10);
        }else{
            //人工车辆通行时间15-25个单位
            sort(manualLaneList);
            lane = manualLaneList.get(0);
            //离开时间等于开始接受收费站服务的时间 加上 通行时间
            car.setLeaveTime(lane.getStartPassTime()+rand.nextInt(16)+10);
        }
        lane.addCar(car);
        System.out.println(car.getName()+" --> "+lane.getName()+"-"+lane.getType()+", arrive at: "+car.getArriveTime() + (car.getType()==0?" ETC车":" 人工车"));
    }

    public static void main(String[] args) {
        Two2 two = new Two2();
        //初始化car_in_flag数组
        //0可生产车辆 1不能生产
        for(int i = 0 ; i < 20 ; i++){
            int index = rand.nextInt(60);
            while(car_in_flag[index] == 1){
                index = rand.nextInt(60);
            }
            car_in_flag[index] = 1;
        }
        //初始化开始时间
        start_time = System.currentTimeMillis();
        Lane lane0 = two.new Lane("lane-0","ETC",etc0);
        Lane lane1 = two.new Lane("lane-1","ETC",etc1);
        Lane lane2 = two.new Lane("lane-2","ETC",etc2);
        Lane lane3 = two.new Lane("lane-3","Mix",mix);
        Lane lane4 = two.new Lane("lane-4","Manual",manual);

        //放进一个列表好排序选择时间最短的列表
        etcLaneList.add(lane0);
        etcLaneList.add(lane1);
        etcLaneList.add(lane2);
        etcLaneList.add(lane3);
        manualLaneList.add(lane3);
        manualLaneList.add(lane4);

        //启动生产线程
        CarPusher carPusher = two.new CarPusher();
        Thread producer = new Thread(carPusher,"carPusher");
        producer.start();

        //启动消费线程
        CarCustomer carCustomer1 = two.new CarCustomer(lane0);
        CarCustomer carCustomer2 = two.new CarCustomer(lane1);
        CarCustomer carCustomer3 = two.new CarCustomer(lane2);
        CarCustomer carCustomer4 = two.new CarCustomer(lane3);
        CarCustomer carCustomer5 = two.new CarCustomer(lane4);

        Thread customer1 = new Thread(carCustomer1,"customer1");
        Thread customer2 = new Thread(carCustomer2,"customer2");
        Thread customer3 = new Thread(carCustomer3,"customer3");
        Thread customer4 = new Thread(carCustomer4,"customer4");
        Thread customer5 = new Thread(carCustomer5,"customer5");
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();
    }




}
