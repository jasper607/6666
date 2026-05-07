import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateDataFiles {
    public static void main(String[] args) {
        // IQ数据
        int[] iqData = {
            101, 128, 133, 146, 112, 125, 146, 103, 150, 93,
            160, 155, 99, 119, 142, 105, 150, 88, 119, 91,
            154, 97, 143, 129, 102, 106, 100, 110, 123, 80,
            105, 160, 94, 88, 130, 82, 154, 123, 87, 95,
            143, 158, 91, 87, 140, 99, 101, 156, 150, 135
        };
        
        // Age数据
        int[] ageData = {
            27, 44, 52, 58, 21, 27, 42, 32, 26, 50,
            30, 27, 58, 55, 57, 22, 32, 34, 30, 24,
            21, 52, 30, 48, 42, 27, 48, 21, 40, 26,
            47, 34, 33, 45, 36, 34, 34, 40, 41, 23,
            56, 20, 50, 54, 45, 34, 31, 57, 52, 20
        };
        
        // 创建iq.txt文件
        try (PrintWriter iqWriter = new PrintWriter(new FileWriter("iq.txt"))) {
            for (int iq : iqData) {
                iqWriter.println(iq);
            }
            System.out.println("iq.txt文件创建成功！");
        } catch (IOException e) {
            System.out.println("创建iq.txt文件时出错: " + e.getMessage());
        }
        
        // 创建age.txt文件
        try (PrintWriter ageWriter = new PrintWriter(new FileWriter("age.txt"))) {
            for (int age : ageData) {
                ageWriter.println(age);
            }
            System.out.println("age.txt文件创建成功！");
        } catch (IOException e) {
            System.out.println("创建age.txt文件时出错: " + e.getMessage());
        }
        
        // 可选：创建一个包含两列数据的完整文件
        try (PrintWriter combinedWriter = new PrintWriter(new FileWriter("iq_age_data.txt"))) {
            combinedWriter.println("IQ\tAge"); // 表头
            for (int i = 0; i < iqData.length; i++) {
                combinedWriter.println(iqData[i] + "\t" + ageData[i]);
            }
            System.out.println("iq_age_data.txt文件创建成功！");
        } catch (IOException e) {
            System.out.println("创建iq_age_data.txt文件时出错: " + e.getMessage());
        }
        
        System.out.println("\n所有数据文件已生成完成！");
        System.out.println("现在可以运行ArrayDemo2程序来读取这些文件了。");
    }
}