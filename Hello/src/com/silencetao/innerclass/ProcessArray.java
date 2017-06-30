package com.silencetao.innerclass;

/**
 * 命令模式,命令执行类
 * @author Silence
 *
 */
public class ProcessArray {

	public void process(int[] target, Command cmd) {
		cmd.process(target);
	}
}
