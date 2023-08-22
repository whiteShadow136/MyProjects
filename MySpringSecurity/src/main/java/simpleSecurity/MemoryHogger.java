package simpleSecurity;

/**
 * @Description:simpleSecurity
 * @Date:2023/8/5
 * @Author:谢锦创
 */
import java.util.ArrayList;
import java.util.List;

public class MemoryHogger {

    public static void main(String[] args) throws InterruptedException {
        List<byte[]> memoryHogList = new ArrayList<>();

//        try {
            while (true) {
                // 分配1MB大小的字节数组，并添加到列表中
                byte[] data = new byte[1024 * 1024 * 1800 * 5];
                memoryHogList.add(data);
                Thread.sleep(10000000);

            }
//        } catch (OutOfMemoryError e) {
//            // 捕获 OutOfMemoryError，表示内存溢出
//            System.out.println("内存溢出！");
//            System.out.println("已分配 " + memoryHogList.size() + " 个20MB大小的字节数组。");
//        } catch (InterruptedException e) {

//        }
    }
}
