public class MyPhone {
    public static void main(String[] args) {
        // 创建一个phone实例
        Phone phone = new Phone();

        // 设置实例内部状态
        phone.hasFingurePrintUnlocker = true;
        phone.price = 2999.9;

        // 创建一个screen的实例，给phone实例的screen引用赋值
        phone.screen = new Screen();

        // 通过引用phone找到Phone的对象，再通过screen找到Screen对象，通过.producer给之赋值
        phone.screen.producer = "京东方";
        phone.screen.size = 6.6;

        Mainboard mainboard = new Mainboard();
        mainboard.model = "EA888";
        mainboard.year = 2019;
        mainboard.cpu = new CPU();
        mainboard.cpu.producer = "德州仪器";
        mainboard.cpu.speed = 3.5;
        mainboard.memory = new Memory();
        mainboard.memory.producer = "三星";
        mainboard.memory.capacity = 4;
        mainboard.storage = new Storage();
        mainboard.storage.producer = "Intel";
        mainboard.storage.capacity = 256;

        phone.prePhone.hasFingurePrintUnlocker = true;
    }
}