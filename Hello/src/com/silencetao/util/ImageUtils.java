package com.silencetao.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import javax.imageio.ImageIO;

/**
 * ͼƬ��������
 * @author Silence
 * create time 2017��12��7�� ����2:53:41
 * @version 1.0.1
 */
public class ImageUtils {

    /**
     * ����ͼƬ����
     * @version 1.0.1 
     * @param srcImageFile Ҫ���ŵ�ͼƬ
     * @param result ���ź�ͼƬ����·��
     * @param height Ŀ��߶�����
     * @param width Ŀ��������
     * @param bb �Ƿ񲹰�
     */
    public static void scaleImage(String srcImageFile, String result, int height, int width, boolean bb) {
        try {
            //���ű���
            double ratio = 0.0;
            
            File file = new File(srcImageFile);
            BufferedImage bi = ImageIO.read(file);
            //ѡ��ͼ��ƽ���ȱ������ٶȾ��и������ȼ���ͼ�������㷨
            Image image = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
            
            //�������
            if (bi.getHeight() > height || bi.getWidth() > width) {
                double ratioHeight = (new Integer(height)).doubleValue() / bi.getHeight();
                double ratioWidth = (new Integer(width)).doubleValue() / bi.getWidth();
                
                if (ratioHeight > ratioWidth) {
                    ratio = ratioHeight;
                } else {
                    ratio = ratioWidth;
                }
                
                /*
                 * ����ת��
                 * ���ر�ʾ���б任�ı任
                 */
                AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
                //ת��ԴBufferedImage����������洢��Ŀ��BufferedImage��
                image = op.filter(bi, null);
            }
            
            //����
            if (bb) {
                //����һ������ΪԤ����ͼ������֮һ��BufferImage
                BufferedImage itemp = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                //����һ��Graphics2D�����Խ������Ƶ���BufferImage��
                Graphics2D g = itemp.createGraphics();
                //������ɫ
                g.setColor(Color.white);
                //ʹ��Graphics2D�����ĵ����ã����Shape���ڲ�����
                g.fillRect(0, 0, width, height);
                
                if (width == itemp.getWidth(null)) {
                    g.drawImage(image, 0, (height - image.getHeight(null)) / 2, image.getWidth(null), image.getHeight(null), Color.white, null);
                } else {
                    g.drawImage(image, (width - image.getWidth(null)) / 2, 0, image.getWidth(null), image.getHeight(null), Color.white, null);
                }
                
                g.dispose();
                image = itemp;
            }
            
            //���ѹ��ͼƬ
            ImageIO.write((BufferedImage) image, "JPEG", new File(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void cropImage(String srcImageFile, String goal, int startX, int startY, int endX, int endY) {
        try {
            File file = new File(srcImageFile);
            BufferedImage bufferedImage = ImageIO.read(file);
            
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            
            if (startX == -1) {
                startX = 0;
            }
            if (startY == -1) {
                startY = 0;
            }
            if (endX == -1) {
                endX = width - 1;
            }
            if (endY == -1) {
                endY = height - 1;
            }
            
            BufferedImage result = new BufferedImage(endX - startX, endY - startY, 4);
            
            for (int x = startX; x < endX; ++x) {
                for (int y = startY; y < endY; ++y) {
                    int rgb = bufferedImage.getRGB(x, y);
                    result.setRGB(x - startX, y - startY, rgb);
                }
            }
            
            ImageIO.write(result, "JPEG", new File(goal));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * ͼƬ����
     * @version 1.0.1 
     * @param sourceImage Ҫ���ŵ�ͼƬ
     * @param ratio ���ű���
     * @return
     */
    public static BufferedImage scale(BufferedImage sourceImage, double ratio) {
        //Ŀ����
        int width = (int) (sourceImage.getWidth() * ratio);
        //Ŀ��߶�
        int height = (int) (sourceImage.getHeight() * ratio);
        
        //ѡ��ͼ��ƽ���ȱ������ٶȾ��и������ȼ���ͼ�������㷨
        Image tempImage = sourceImage.getScaledInstance(width, height, sourceImage.SCALE_SMOOTH);
            
        /*
         * ����ת��
         * ���ر�ʾ���б任�ı任
         */
        AffineTransformOp affineTransformOp = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
        
        //ת��ԴBufferedImage����������洢��Ŀ��BufferedImage��
        tempImage = affineTransformOp.filter(sourceImage, null);
        
        //����һ������ΪԤ����ͼ������֮һ��BufferImage
        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //����һ��Graphics2D�����Խ������Ƶ���BufferImage��
        Graphics2D graphics = resultImage.createGraphics();
        //������ɫ
        graphics.setColor(Color.white);
        //ʹ��Graphics2D�����ĵ����ã����Shape���ڲ�����
        graphics.fillRect(0, 0, width, height);
        
        if (width == resultImage.getWidth(null)) {
            graphics.drawImage(tempImage, 0, (height - tempImage.getHeight(null)) / 2,
                    tempImage.getWidth(null), tempImage.getHeight(null), Color.white, null);
        } else {
            graphics.drawImage(tempImage, (width - tempImage.getWidth(null)) / 2, 0,
                    tempImage.getWidth(null), tempImage.getHeight(null), Color.white, null);
        }
        
        graphics.dispose();
        
        return resultImage;
    }
    
    /**
     * ͼƬ���Ų��ü�
     * @version 1.0.1 
     * @param inputStream Ҫ�ü���ͼƬ������
     * @param ratio ���ű���
     * @param resultPath �ü����ŵ�λ��
     * @param startX �ü���ʼx����
     * @param startY �ü���ʼy����
     * @param endX �ü�����x����
     * @param endY �ü�����y����
     * @param width �ü���ͼƬ���
     * @param height �ü���ͼƬ�߶�
     */
    public static void crop(InputStream inputStream, double ratio, String resultPath,
            int startX, int startY, int endX, int endY, int width, int height) {
        try {
            BufferedImage sourceImage = ImageIO.read(inputStream);
            
            BufferedImage scaleImage = scale(sourceImage, ratio);
            
            ImageIO.write(scaleImage, "JPEG", new File("img/temp01.jpg"));
            
            BufferedImage tempImage = new BufferedImage(endX - startX, endY - startY, 4);
            
            for (int x = startX; x < endX; ++x) {
                for (int y = startY; y < endY; ++y) {
                    int rgb = scaleImage.getRGB(x, y);
                    tempImage.setRGB(x - startX, y - startY, rgb);
                }
            }
            
            ImageIO.write(tempImage, "JPEG", new File("img/temp02.jpg"));
            
            if (tempImage.getHeight() > height || tempImage.getWidth() > width) {
                double ratioHeight = (new Integer(height)).doubleValue() / tempImage.getHeight();
                double ratioWidth = (new Integer(width)).doubleValue() / tempImage.getWidth();
                
                if (ratioHeight > ratioWidth) {
                    ratio = ratioHeight;
                } else {
                    ratio = ratioWidth;
                }
            }
            
            BufferedImage resultImage = scale(tempImage, ratio);
            ImageIO.write(resultImage, "JPEG", new File(resultPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws Exception {
//        ImageUtils.scale("img/demo.jpg", "img/scale09.jpg", 450, 800, false);
        
//        ImageUtils.cropImage("img/scale08.jpg", "img/crop05.jpg", 500, 0, 800, 300);
        
        InputStream stream = new FileInputStream("img/1207.JPG");
        ImageUtils.crop(stream, 0.7, "img/crop010.jpg", 100, 100, 1600, 1600, 300, 300);
    }
}
