package com.bailiban.wedding_hlh.entity;

import lombok.Data;

@Data
public class Hotel {

  private long hotelId;
  private String hotelName;
  private String hotelAddress;
  private String hotelTel;
  private String hotelStar;
  //酒店图片
  private String hotelImg;

  public String getHotelImg() {
    return hotelImg;
  }

  public void setHotelImg(String hotelImg) {
    this.hotelImg = hotelImg;
  }

  public long getHotelId() {
    return hotelId;
  }

  public void setHotelId(long hotelId) {
    this.hotelId = hotelId;
  }


  public String getHotelName() {
    return hotelName;
  }

  public void setHotelName(String hotelName) {
    this.hotelName = hotelName;
  }


  public String getHotelAddress() {
    return hotelAddress;
  }

  public void setHotelAddress(String hotelAddress) {
    this.hotelAddress = hotelAddress;
  }


  public String getHotelTel() {
    return hotelTel;
  }

  public void setHotelTel(String hotelTel) {
    this.hotelTel = hotelTel;
  }


  public String getHotelStar() {
    return hotelStar;
  }

  public void setHotelStar(String hotelStar) {
    this.hotelStar = hotelStar;
  }

}
