package com.silencetao.innerclass;

/**
 * �����ڲ���,����������
 * @author Silence
 *
 */

abstract class Device {
	private String name;
	public abstract double getPrice();
	
	public Device() {
		
	}
	
	public Device(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

public class AnonymousInner {

	public void test(Device d) {
		System.out.println(d.getName() + "," + d.getPrice());
	}
	
	public static void main(String[] args) {
		AnonymousInner a = new AnonymousInner();
		a.test(new Device("Silence") {
			@Override
			public double getPrice() {
				return 12.15;
			}
		});
		Device device = new Device() {
			{
				System.out.println("�����ڲ���ĳ�ʼ���顭��");
			}
			
			@Override
			public double getPrice() {
				return 89.33;
			}
			
			@Override
			public String getName() {
				return "����";
			}
		};
		
		a.test(device);
	}
}
