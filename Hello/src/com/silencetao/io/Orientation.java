package com.silencetao.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * readResolve()·½·¨
 * @author Silence
 *
 */
public class Orientation implements Serializable {
	private static final Orientation HORIZONTAL = new Orientation(1);
	private static final Orientation VERTICAL = new Orientation(2);
	private int value;
	
	private Orientation(int value) {
		this.value = value;
	}
	
	private Object readResolve() {
		if (value == 1) {
			return HORIZONTAL;
		} else if (value == 2) {
			return VERTICAL;
		}
		return null;
	}
	
	public static void main(String[] args) {
		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io/Orientation.txt"));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io/Orientation.txt"));
			) {
			oos.writeObject(Orientation.HORIZONTAL);
			Orientation ori = (Orientation) ois.readObject();
			System.out.println(ori == Orientation.HORIZONTAL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
