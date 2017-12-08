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
 * 图片处理工具类
 * @author Silence
 * create time 2017年12月7日 下午2:53:41
 * @version 1.0.1
 */
public class ImageUtils {

    /**
     * 缩放图片方法
     * @version 1.0.1 
     * @param srcImageFile 要缩放的图片
     * @param result 缩放后图片保存路径
     * @param height 目标高度像素
     * @param width 目标宽度像素
     * @param bb 是否补白
     */
    public static void scaleImage(String srcImageFile, String result, int height, int width, boolean bb) {
        try {
            //缩放比例
            double ratio = 0.0;
            
            File file = new File(srcImageFile);
            BufferedImage bi = ImageIO.read(file);
            //选择图像平滑度比缩放速度具有更高优先级的图像缩放算法
            Image image = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
            
            //计算比例
            if (bi.getHeight() > height || bi.getWidth() > width) {
                double ratioHeight = (new Integer(height)).doubleValue() / bi.getHeight();
                double ratioWidth = (new Integer(width)).doubleValue() / bi.getWidth();
                
                if (ratioHeight > ratioWidth) {
                    ratio = ratioHeight;
                } else {
                    ratio = ratioWidth;
                }
                
                /*
                 * 仿射转换
                 * 返回表示剪切变换的变换
                 */
                AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
                //转换源BufferedImage，并将结果存储在目标BufferedImage中
                image = op.filter(bi, null);
            }
            
            //补白
            if (bb) {
                //构造一个类型为预定义图像类型之一的BufferImage
                BufferedImage itemp = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                //创建一个Graphics2D，可以将它绘制到此BufferImage中
                Graphics2D g = itemp.createGraphics();
                //控制颜色
                g.setColor(Color.white);
                //使用Graphics2D上下文的设置，填充Shape的内部区域
                g.fillRect(0, 0, width, height);
                
                if (width == itemp.getWidth(null)) {
                    g.drawImage(image, 0, (height - image.getHeight(null)) / 2, image.getWidth(null), image.getHeight(null), Color.white, null);
                } else {
                    g.drawImage(image, (width - image.getWidth(null)) / 2, 0, image.getWidth(null), image.getHeight(null), Color.white, null);
                }
                
                g.dispose();
                image = itemp;
            }
            
            //输出压缩图片
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
     * 图片缩放
     * @version 1.0.1 
     * @param sourceImage 要缩放的图片
     * @param ratio 缩放比例
     * @return
     */
    public static BufferedImage scale(BufferedImage sourceImage, double ratio) {
        //目标宽度
        int width = (int) (sourceImage.getWidth() * ratio);
        //目标高度
        int height = (int) (sourceImage.getHeight() * ratio);
        
        //选择图像平滑度比缩放速度具有更高优先级的图像缩放算法
        Image tempImage = sourceImage.getScaledInstance(width, height, sourceImage.SCALE_SMOOTH);
            
        /*
         * 仿射转换
         * 返回表示剪切变换的变换
         */
        AffineTransformOp affineTransformOp = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
        
        //转换源BufferedImage，并将结果存储在目标BufferedImage中
        tempImage = affineTransformOp.filter(sourceImage, null);
        
        //构造一个类型为预定义图像类型之一的BufferImage
        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //创建一个Graphics2D，可以将它绘制到此BufferImage中
        Graphics2D graphics = resultImage.createGraphics();
        //控制颜色
        graphics.setColor(Color.white);
        //使用Graphics2D上下文的设置，填充Shape的内部区域
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
     * 图片缩放并裁剪
     * @version 1.0.1 
     * @param inputStream 要裁剪的图片输入流
     * @param ratio 缩放比例
     * @param resultPath 裁剪后存放的位置
     * @param startX 裁剪开始x坐标
     * @param startY 裁剪开始y坐标
     * @param endX 裁剪结束x坐标
     * @param endY 裁剪结束y坐标
     * @param width 裁剪后图片宽度
     * @param height 裁剪后图片高度
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
