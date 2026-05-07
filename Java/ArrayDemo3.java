import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayDemo3 {
    public static void main(String[] args) throws FileNotFoundException {
        // 安全地设置控制台编码
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {
            System.out.println("注意: UTF-8编码设置失败，使用系统默认编码");
        }
        
        File f = new File("iq.txt");
        File f2 = new File("age.txt");
        
        // 检查文件是否存在
        if (!f.exists() || !f2.exists()) {
            System.out.println("数据文件不存在，请先运行CreateDataFiles程序生成数据文件。");
            return;
        }

        Scanner sc = new Scanner(f);
        Scanner sc2 = new Scanner(f2);

        List<Integer> iqList = new ArrayList<>();
        List<Integer> ageList = new ArrayList<>();

        // 读取iq文件
        while (sc.hasNextInt()) {
            iqList.add(sc.nextInt());
        }
        sc.close();

        // 读取age文件
        while (sc2.hasNextInt()) {
            ageList.add(sc2.nextInt());
        }
        sc2.close();

        // 转换为数组
        int[] iq = new int[iqList.size()];
        int[] age = new int[ageList.size()];

        for (int i = 0; i < iqList.size(); i++) {
            iq[i] = iqList.get(i);
        }
        for (int i = 0; i < ageList.size(); i++) {
            age[i] = ageList.get(i);
        }

        // 显示原始数据
        System.out.println("原始IQ数据: " + Arrays.toString(iq));
        System.out.println("原始Age数据: " + Arrays.toString(age));
        
        // 处理IQ值（加倍）
        increase(iq);

        // 输出处理后的数据
        System.out.println("\n加倍后IQ数据: " + Arrays.toString(iq));
        System.out.println("Age数据: " + Arrays.toString(age));

        // 显示配对信息
        System.out.println("\n--- IQ和Age配对信息 ---");
        System.out.println("IQ\tAge");
        for (int i = 0; i < Math.min(iq.length, age.length); i++) {
            System.out.println(iq[i] + "\t" + age[i]);
        }
        
        // 统计信息
        System.out.println("\n--- 数据统计 ---");
        System.out.println("总数据量: " + iq.length + " 对");
        System.out.println("平均IQ: " + calculateAverage(iq));
        System.out.println("平均年龄: " + calculateAverage(age));
    }

    /**
     * 将数组中的每个元素加倍
     */
    public static void increase(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * 2;
        }
    }
    
    /**
     * 计算数组的平均值
     */
    public static double calculateAverage(int[] a) {
        if (a.length == 0) return 0;
        int sum = 0;
        for (int value : a) {
            sum += value;
        }
        return Math.round((double) sum / a.length * 100.0) / 100.0;
    }
}