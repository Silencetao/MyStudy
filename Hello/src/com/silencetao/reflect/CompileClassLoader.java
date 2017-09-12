package com.silencetao.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 自定义的类加载器
 * @author Silence
 * create time 2017年9月12日 上午10:42:30
 * @version 1.0.1
 */
public class CompileClassLoader extends ClassLoader {

    /**
     * 读取一个文件的内容
     * @version 1.0.1 
     * @param filename
     * @return
     * @throws IOException
     */
    private byte[] getBytes(String filename) throws IOException {
        File file = new File(filename);
        long len = file.length();
        byte[] raw = new byte[(int)len];
        
        try (
                FileInputStream fin = new FileInputStream(file);
            ) {
            //一次性读取Class文件的全部二进制数据
            int r = fin.read(raw);
            if (r != len) {
                throw new IOException("无法读取全部文件：" + r + "!=" + len);
            }
            
            return raw;
        }
    }
    
    /**
     * 定义编译指定Java文件的方法
     * @version 1.0.1 
     * @param javaFile
     * @return
     * @throws IOException 
     */
    private boolean compile(String javaFile) throws IOException {
        System.out.println("CompileClassLoader:正在编译" + javaFile + "...");
        
        Process process = Runtime.getRuntime().exec("javac" + javaFile);
        
        try {
            //其它线程都等待这个线程完成
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //获取javac线程的退出值
        int ret = process.exitValue();
        
        return ret == 0;
    }
    
    /**
     * 重写ClassLoader的findClass方法
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        
        String fileStub = "src/" + name.replace(".", "/");
        String javaFilename = fileStub + ".java";
        String classFilename = fileStub + ".class";
        
        File javaFile = new File(javaFilename);
        File classFile = new File(classFilename);
        
        /*
         * 当指定的Java源文件存在，且Class文件不存在，或者Java源文件的修改
         * 时间比Class文件的修改时间更晚时，重新编译
         */
        if (javaFile.exists() && (!classFile.exists() ||
                javaFile.lastModified() > classFile.lastModified())) {
            try {
                /*
                 * 如果编译失败，或者Class文件不存在
                 */
                if (!compile(javaFilename) || !classFile.exists()) {
                    throw new ClassNotFoundException("ClassNotFoundException:" + javaFilename);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        /*
         * 如果Class文件存在，系统负责将该文件转换成Class对象
         */
        if (classFile.exists()) {
            try {
                //将Class文件的二进制数据读入数组
                byte[] raw = getBytes(classFilename);
                //调用ClassLoader的defineClass方法将二进制数据转换成class对象
                clazz = defineClass(name, raw, 0, raw.length);
            } catch (ClassFormatError e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        /*
         * 如果class为null，表明加载失败，则抛出异常
         */
        if (clazz == null) {
            throw new ClassNotFoundException(name);
        }
        
        return clazz;
    }
    
    public static void main(String[] args) throws Exception {
        /*
         * 如果运行该程序没有参数，即没有目标类
         */
        if (args.length < 1) {
            System.out.println("缺少目标类，请按如下格式运行Java源文件");
            System.out.println("java ComileClassLoader ClassName");
        }
        
        //第一个参数是需要运行的类
        String progClass = "com.silencetao.reflect.Hello";
        
        /*
         * 剩下的参数将作为运行目标时的参数
         * 将这些参数复制到一个新的数组中
         */
        String progArags = "Hello World!";
//        System.arraycopy(args, 1, progArags, 0, progArags.length);
        
        CompileClassLoader ccl = new CompileClassLoader();
        //加载需要的类
        Class<?> clazz = ccl.loadClass(progClass);
        //获取需要运行的类的主方法
        Method main = clazz.getMethod("main", (new String[0]).getClass());
        Object argsArray[] = {progArags};
        main.invoke(null, argsArray);
    }
}
