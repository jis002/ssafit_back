package com.ssafy.fit.model.dto;

public class Video {
	
	private int id;
	private String title;
	private String fitPartName;
	private String youtubeId;
	private String channelName;
	private int viewCnt;
	private String img;
	

	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public Video() {
		super();
	}
	
	
	public Video(String title, String fitPartName, String youtubeId, String channelName, int viewCnt) {
		this.title = title;
		this.fitPartName = fitPartName;
		this.youtubeId = youtubeId;
		this.channelName = channelName;
		this.viewCnt = viewCnt;
	}



	public Video(int id, String title, String fitPartName, String youtubeId, String channelName, int viewCnt) {
		this.id = id;
		this.title = title;
		this.fitPartName = fitPartName;
		this.youtubeId = youtubeId;
		this.channelName = channelName;
		this.viewCnt = viewCnt;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFitPartName() {
		return fitPartName;
	}

	public void setFitPartName(String fitPartName) {
		this.fitPartName = fitPartName;
	}

	public String getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Video [it=" + id + ", title=" + title + ", fitPartName=" + fitPartName + ", youtubeId=" + youtubeId + ", channelName="
				+ channelName + ", viewCnt=" + viewCnt + ", img=" + img + "]";
	}
}