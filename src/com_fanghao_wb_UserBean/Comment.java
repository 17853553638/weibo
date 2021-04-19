package com_fanghao_wb_UserBean;

public class Comment {
	
	
			private int id;
			
			private int wbid;
			
			private String content;
			
			private String time;
			
			private int userid;
			private String username;

			public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
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

			public int getUserid() {
				return userid;
			}

			public void setUserid(int userid) {
				this.userid = userid;
			}

}
