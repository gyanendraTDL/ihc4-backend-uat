package com.tdl.river.util.models;

public class ScoreCard {
	
	private int id;
	private int isHeader;
	private int excellent;
	private String excellentPer;
	private int good;
	private String goodPer;
	private int neutral;
	private String neutralPer;
	private int avg;
	private String avgPer;
	private int poor;
	private String poorPer;
	private String subServiceScore;
	private String serviceScore;
	private String factorName;
	private String index;
	private String color;
	private int hasSubQue;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public int getIsHeader() {
		return isHeader;
	}
	public void setIsHeader(int isHeader) {
		this.isHeader = isHeader;
	}
	public int getExcellent() {
		return excellent;
	}
	public void setExcellent(int excellent) {
		this.excellent = excellent;
	}
	public String getExcellentPer() {
		return excellentPer;
	}
	public void setExcellentPer(String excellentPer) {
		this.excellentPer = excellentPer;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public String getGoodPer() {
		return goodPer;
	}
	public void setGoodPer(String goodPer) {
		this.goodPer = goodPer;
	}
	public int getNeutral() {
		return neutral;
	}
	public void setNeutral(int neutral) {
		this.neutral = neutral;
	}
	public String getNeutralPer() {
		return neutralPer;
	}
	public void setNeutralPer(String neutralPer) {
		this.neutralPer = neutralPer;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public String getAvgPer() {
		return avgPer;
	}
	public void setAvgPer(String avgPer) {
		this.avgPer = avgPer;
	}
	public int getPoor() {
		return poor;
	}
	public void setPoor(int poor) {
		this.poor = poor;
	}
	public String getPoorPer() {
		return poorPer;
	}
	public void setPoorPer(String poorPer) {
		this.poorPer = poorPer;
	}
	public String getSubServiceScore() {
		return subServiceScore;
	}
	public void setSubServiceScore(String subServiceScore) {
		this.subServiceScore = subServiceScore;
	}
	public String getServiceScore() {
		return serviceScore;
	}
	public void setServiceScore(String serviceScore) {
		this.serviceScore = serviceScore;
	}
	public String getFactorName() {
		return factorName;
	}
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}
	public int getHasSubQue() {
		return hasSubQue;
	}
	public void setHasSubQue(int hasSubQue) {
		this.hasSubQue = hasSubQue;
	}
	@Override
	public String toString() {
		return "ScoreCard [isHeader=" + isHeader + ", excellent=" + excellent + ", excellentPer=" + excellentPer
				+ ", good=" + good + ", goodPer=" + goodPer + ", neutral=" + neutral + ", neutralPer=" + neutralPer
				+ ", avg=" + avg + ", avgPer=" + avgPer + ", poor=" + poor + ", poorPer=" + poorPer
				+ ", subServiceScore=" + subServiceScore + ", serviceScore=" + serviceScore + ", factorName="
				+ factorName + ", index=" + index + "]";
	}
	
	
	
	

}
