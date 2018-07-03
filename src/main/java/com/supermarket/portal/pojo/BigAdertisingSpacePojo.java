package com.supermarket.portal.pojo;

import java.io.Serializable;

public class BigAdertisingSpacePojo implements Serializable {

	/**
	 * net transmit
	 */
	private static final long serialVersionUID = -8869817903720447454L;
	
	private String srcB;
	
	private int height;
	
	private String alt;
	
	private int width;
	
	private String src;
	
	private int widthB;
	
	private String href;
	
	private int heightB;

	@Override
	public String toString() {
		return "BigAdertisingSpacePojo [srcB=" + srcB + ", height=" + height + ", alt=" + alt + ", width=" + width
				+ ", src=" + src + ", widthB=" + widthB + ", href=" + href + ", heightB=" + heightB + "]";
	}

	public String getSrcB() {
		return srcB;
	}

	public void setSrcB(String srcB) {
		this.srcB = srcB;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public int getWidthB() {
		return widthB;
	}

	public void setWidthB(int widthB) {
		this.widthB = widthB;
	}

	public String gethref() {
		return href;
	}

	public void sethref(String href) {
		this.href = href;
	}

	public int getHeightB() {
		return heightB;
	}

	public void setHeightB(int heightB) {
		this.heightB = heightB;
	}

}
