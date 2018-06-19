package com;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName ="vehicle")
public class Vehicle {
	@DatabaseField(columnName="illegalType")
	private String illegalType;	//违法类别
	@DatabaseField(columnName="illegalPlace")
	private String illegalPlace;//违法地点
	@DatabaseField(columnName="direction")
	private String direction;//行驶方向
	@DatabaseField(columnName="dirLine")
	private String dirLine;//行驶车道
	@DatabaseField(columnName="illegalDate")
	private String illegalDate;//违法日期
	@DatabaseField(columnName="plate")
	private String plate;//车牌号
	@DatabaseField(columnName="vehicleType")
	private String vehicleType;//车辆类型
	@DatabaseField(columnName="speed")
	private String speed;//车速_
	@DatabaseField(columnName="maxSpeed")
	private String maxSpeed;//最高限速
	@DatabaseField(columnName="imgIndex")
	private String imgIndex;//图片序号
	
	@DatabaseField(columnName="updateTime")
	private String updateTime;//更新日期
	@DatabaseField(columnName="imgUrl")
	private String imgUrl;//图片地址
	@DatabaseField(columnName="esId")
	private String esId;//Es-id
	@DatabaseField(columnName="pname")
	private String pname;//生成的名称
	
	//违法类别_违法地点_行驶方向_行驶车道_违法日期_车牌号_车辆类型_车速_最高限速_图片序号
	
	public String getIllegalType() {
		return illegalType;
	}
	public void setIllegalType(String illegalType) {
		this.illegalType = illegalType;
	}
	public String getIllegalPlace() {
		return illegalPlace;
	}
	public void setIllegalPlace(String illegalPlace) {
		this.illegalPlace = illegalPlace;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getDirLine() {
		return dirLine;
	}
	public void setDirLine(String dirLine) {
		this.dirLine = dirLine;
	}
	public String getIllegalDate() {
		return illegalDate;
	}
	public void setIllegalDate(String illegalDate) {
		this.illegalDate = illegalDate;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getImgIndex() {
		return imgIndex;
	}
	public void setImgIndex(String imgIndex) {
		this.imgIndex = imgIndex;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getEsId() {
		return esId;
	}
	public void setEsId(String esId) {
		this.esId = esId;
	}
	
	public String getPname() {
		String pp  =
		illegalType + "_"+
		illegalPlace + "_"+
		direction  + "_"+
		dirLine + "_"+
		illegalDate + "_"+
		plate + "_"+
		vehicleType + "_"+
		speed + "_"+
		maxSpeed + "_"+
		imgIndex+".jpg";
		return pp;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}


}
