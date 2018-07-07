package com.cn.supermarket.images;

import java.util.Arrays;

public class ImageSplitTest {
	
	private String image="http://192.168.25.133/group1/M00/00/00/wKgZhVtAOaqAAt0jAAD6nNM0jms226.jpg,http://192.168.25.133/group1/M00/00/00/wKgZhVtAOaqAbV7NAABvaLLSa9M795.jpg,http://192.168.25.133/group1/M00/00/00/wKgZhVtAOaqAbUcnAAH2YoXtJaE421.jpg,http://192.168.25.133/group1/M00/00/00/wKgZhVtAOauAOq70AAIZC9NtPGU637.jpg,http://192.168.25.133/group1/M00/00/00/wKgZhVtAOauAJh5aAAIsWxxi_zE455.jpg";
	
	public static void main(String[] args) {
		new ImageSplitTest().test1();
	}
	
	private void test1() {
		ImageTest imageTest = new ImageTest(image);
		//String[] images = imageTest.getImages();
		//System.out.println(Arrays.toString(imageTest.images));
		System.out.println(Arrays.toString(imageTest.images));
		
	}

	
}

class ImageTest{
	
	//private String image;
	private String image="http://192.168.25.133/group1/M00/00/00/wKgZhVtAOaqAAt0jAAD6nNM0jms226.jpg,http://192.168.25.133/group1/M00/00/00/wKgZhVtAOaqAbV7NAABvaLLSa9M795.jpg,http://192.168.25.133/group1/M00/00/00/wKgZhVtAOaqAbUcnAAH2YoXtJaE421.jpg,http://192.168.25.133/group1/M00/00/00/wKgZhVtAOauAOq70AAIZC9NtPGU637.jpg,http://192.168.25.133/group1/M00/00/00/wKgZhVtAOauAJh5aAAIsWxxi_zE455.jpg";
	
	public String[] images;

	public String getImage() {
		return image;
	}
	
	public ImageTest() {
	}

	public ImageTest(String image) {
		super();
		this.image = image;
		this.images=getImages();
	}

	public void setImage(String image) {
		if (image!=null) {
			images=image.split(",");
		}
	}

	public String[] getImages() {
		/*if (image!=null) {
			images=image.split(",");
			return images;
		}
		return null;*/
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}
	
	
}