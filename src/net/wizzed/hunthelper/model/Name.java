package net.wizzed.hunthelper.model;

import java.io.Serializable;

public class Name implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5600571388691252173L;
	public static final int EN = 0;
	public static final int DE = 1;
	public static final int FR = 2;
	public static final int JP = 3;

	String name_en = "";
	String name_de = "";
	String name_fr = "";
	String name_jp = "";

	public Name(String en, String de, String fr, String jp) {
		setNames(en, de, fr, jp);
	}

	public void setNames(String en, String de, String fr, String jp) {
		name_en = en;
		name_de = de;
		name_fr = fr;
		name_jp = jp;
	}

	public String getName(int lang) {
		switch (lang) {
		case EN:
			return name_en;
		case DE:
			return name_de;
		case FR:
			return name_fr;
		case JP:
			return name_jp;
		default:
			return name_en;
		}
	}

	public static String getStringName(int lang) {
		switch (lang) {
		case EN:
			return "EN";
		case DE:
			return "DE";
		case FR:
			return "FR";
		case JP:
			return "JP";
		default:
			return "EN";
		}
	}

}
