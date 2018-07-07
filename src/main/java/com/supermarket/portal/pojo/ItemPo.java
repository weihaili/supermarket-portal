package com.supermarket.portal.pojo;

import com.supermarket.pojo.TbItem;

public class ItemPo extends TbItem {
	public String[] images;
	
	public ItemPo(){
		images=getImages();
	}
	
	public String[] getImages() {
		String sImage=super.getImage();
		if (sImage!=null) {
			images=sImage.split(",");
			return images;
		}
		return null;
	}

	public void setImages(String[] images) {
		String sImage = super.getImage();
		if (sImage!=null) {
			images=sImage.split(",");
		}
	}


}
