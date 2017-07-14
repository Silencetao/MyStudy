package com.silencetao.nio;

import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * 使用WatchService监控文件变化
 * @author Silence
 *
 */
public class WatchServiceTest {

	public static void main(String[] args) throws Exception {
		//获取文件系统的WatchService对象
		WatchService watchService = FileSystems.getDefault().newWatchService();
		//为D:盘根目录路径注册监听
		Paths.get("D:/").register(watchService, StandardWatchEventKinds.ENTRY_CREATE, 
				StandardWatchEventKinds.ENTRY_MODIFY, 
				StandardWatchEventKinds.ENTRY_DELETE);
		while (true) {
			//获取下一个文件变化事件
			WatchKey key = watchService.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				System.out.println(event.context() + "文件发生了" + event.kind() + "事件");
			}
			//重设WatchKey
			boolean valid = key.reset();
			//如果重设失败，退出监听
			if (!valid) {
				break ;
			}
		}
	}
}
