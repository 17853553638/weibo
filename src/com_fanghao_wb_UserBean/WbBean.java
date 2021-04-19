package com_fanghao_wb_UserBean;

import java.util.List;



public class WbBean {
					private int wbid;//总微博条数
					private int DZ;
					private String content; //微博内容
					
					private String  time;//微博发送时间
					
					private String img;//微博发送图片
					
					private int userid;//发布者的ID
					
					private  String username;//发布者的用户名
					
					private String topic;
					
					private String role;//发布者的头像
					private int dzsum;
					private int pinglun;
					private int comment;
					private List<Comment> coms;
					private int dzj;
				

					
					private List<Comment> comments;
					public List<Comment> getComments() {
						return comments;
					}
					public void setComments(List<Comment> comments) {
						this.comments = comments;
					}
					public int getDzj() {
						return dzj;
					}

					public void setDzj(int dzj) {
						this.dzj = dzj;
					}

					public List<Comment> getComs() {
						return coms;
					}

					public void setComs(List<Comment> coms) {
						this.coms = coms;
					}

					public int getPinglun() {
						return pinglun;
					}
					public int getDZ() {
						return DZ;
					}
					public void setDZ(int dZ) {
						DZ = dZ;
					}
					public void setPinglun(int pinglun) {
						this.pinglun = pinglun;
					}

					public int getDzsum() {
						return dzsum;
					}

					public void setDzsum(int dzsum) {
						this.dzsum = dzsum;
					}

					public int getWbid() {
						return wbid;
					}

					public void setWbid(int wbid) {
						this.wbid = wbid;
					}

					public String getContent() {
						return content;
					}

					public void setContent(String content) {
						this.content = content;
					}

					public String getTime() {
						return time;
					}

					public void setTime(String time) {
						this.time = time;
					}

					public String getImg() {
						return img;
					}

					public void setImg(String img) {
						this.img = img;
					}

					public int getUserid() {
						return userid;
					}

					public void setUserid(int userid) {
						this.userid = userid;
					}

					public String getUsername() {
						return username;
					}

					public void setUsername(String username) {
						this.username = username;
					}
					public String getTopic() {
						return topic;
					}

					public void setTopic(String topic) {
						this.topic = topic;
					}

					public String getRole() {
						return role;
					}

					public void setRole(String role) {
						this.role = role;
					}

					public int getComment() {
						return comment;
					}

					public void setComment(int comment) {
						comment = comment;
					}
	
	
	
}
