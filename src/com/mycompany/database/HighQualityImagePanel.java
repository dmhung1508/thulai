package com.mycompany.database;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HighQualityImagePanel extends JPanel {
    private BufferedImage image;

    public HighQualityImagePanel() {
        try {
            // Đọc ảnh từ file
            image = Utils.getQR(100000, "Thanh toán tiền điện");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            Graphics2D g2d = (Graphics2D) g;

            // Bật các chế độ tăng chất lượng
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Resize ảnh theo kích thước panel
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            g2d.drawImage(image, 0, 0, panelWidth, panelHeight, this);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hiển thị ảnh chất lượng cao");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        HighQualityImagePanel panel = new HighQualityImagePanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}
