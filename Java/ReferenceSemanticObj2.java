import java.awt.*;
import javax.swing.*;

public class ReferenceSemanticObj2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reference Semantics Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // 设置布局管理器

        DrawingPanel panel1 = new DrawingPanel(300, 200);
        DrawingPanel panel2 = panel1; // both variables refer to the same object

        panel1.setBackground(Color.RED);
        panel2.setBackground(Color.RED); // this affects the same panel as panel1

        // 创建按钮
        JButton button = new JButton("点击我!");
        button.addActionListener(e -> {
            System.out.println("按钮被点击了!");
            JOptionPane.showMessageDialog(frame, "你好! 这是一个按钮点击事件。");
        });

        // 创建面板容器，将绘图面板和按钮放在一起
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        containerPanel.add(panel1, BorderLayout.CENTER);
        containerPanel.add(button, BorderLayout.SOUTH);

        frame.add(containerPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    static class DrawingPanel extends JPanel {
        private int width;
        private int height;

        public DrawingPanel(int width, int height) {
            this.width = width;
            this.height = height;
            setBackground(Color.RED);
            setPreferredSize(new Dimension(width, height));
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // 可选：在面板上绘制一些内容
            g.setColor(Color.WHITE);
            g.drawString("这是一个绘图面板", 10, 20);
        }
    }
}