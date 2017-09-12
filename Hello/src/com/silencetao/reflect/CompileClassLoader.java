package com.silencetao.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * �Զ�����������
 * @author Silence
 * create time 2017��9��12�� ����10:42:30
 * @version 1.0.1
 */
public class CompileClassLoader extends ClassLoader {

    /**
     * ��ȡһ���ļ�������
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
            //һ���Զ�ȡClass�ļ���ȫ������������
            int r = fin.read(raw);
            if (r != len) {
                throw new IOException("�޷���ȡȫ���ļ���" + r + "!=" + len);
            }
            
            return raw;
        }
    }
    
    /**
     * �������ָ��Java�ļ��ķ���
     * @version 1.0.1 
     * @param javaFile
     * @return
     * @throws IOException 
     */
    private boolean compile(String javaFile) throws IOException {
        System.out.println("CompileClassLoader:���ڱ���" + javaFile + "...");
        
        Process process = Runtime.getRuntime().exec("javac" + javaFile);
        
        try {
            //�����̶߳��ȴ�����߳����
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //��ȡjavac�̵߳��˳�ֵ
        int ret = process.exitValue();
        
        return ret == 0;
    }
    
    /**
     * ��дClassLoader��findClass����
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
         * ��ָ����JavaԴ�ļ����ڣ���Class�ļ������ڣ�����JavaԴ�ļ����޸�
         * ʱ���Class�ļ����޸�ʱ�����ʱ�����±���
         */
        if (javaFile.exists() && (!classFile.exists() ||
                javaFile.lastModified() > classFile.lastModified())) {
            try {
                /*
                 * �������ʧ�ܣ�����Class�ļ�������
                 */
                if (!compile(javaFilename) || !classFile.exists()) {
                    throw new ClassNotFoundException("ClassNotFoundException:" + javaFilename);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        /*
         * ���Class�ļ����ڣ�ϵͳ���𽫸��ļ�ת����Class����
         */
        if (classFile.exists()) {
            try {
                //��Class�ļ��Ķ��������ݶ�������
                byte[] raw = getBytes(classFilename);
                //����ClassLoader��defineClass����������������ת����class����
                clazz = defineClass(name, raw, 0, raw.length);
            } catch (ClassFormatError e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        /*
         * ���classΪnull����������ʧ�ܣ����׳��쳣
         */
        if (clazz == null) {
            throw new ClassNotFoundException(name);
        }
        
        return clazz;
    }
    
    public static void main(String[] args) throws Exception {
        /*
         * ������иó���û�в�������û��Ŀ����
         */
        if (args.length < 1) {
            System.out.println("ȱ��Ŀ���࣬�밴���¸�ʽ����JavaԴ�ļ�");
            System.out.println("java ComileClassLoader ClassName");
        }
        
        //��һ����������Ҫ���е���
        String progClass = "com.silencetao.reflect.Hello";
        
        /*
         * ʣ�µĲ�������Ϊ����Ŀ��ʱ�Ĳ���
         * ����Щ�������Ƶ�һ���µ�������
         */
        String progArags = "Hello World!";
//        System.arraycopy(args, 1, progArags, 0, progArags.length);
        
        CompileClassLoader ccl = new CompileClassLoader();
        //������Ҫ����
        Class<?> clazz = ccl.loadClass(progClass);
        //��ȡ��Ҫ���е����������
        Method main = clazz.getMethod("main", (new String[0]).getClass());
        Object argsArray[] = {progArags};
        main.invoke(null, argsArray);
    }
}
