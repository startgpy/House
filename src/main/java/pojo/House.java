package pojo;

import java.util.Date;

public class House {
	
	
	private int id;//���
	private int street_id;//�ֵ�id
	private int user_id;//�û�id
	private int type_id;//����id
	private String title;//����
	private String description;//����
	private int price;//�۸�
	private Date pubdate;//����
	private int floorage;//���
	private String contact;//�绰����
	//��չ�ֶ�
	private String dname;
	private String sname;
	private String tname;
	private String dateString;
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	private int did;//����id
	private int index;//ҳ�루���Ŀ�ʼ�飩
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStreet_id() {
		return street_id;
	}
	public void setStreet_id(int street_id) {
		this.street_id = street_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public int getFloorage() {
		return floorage;
	}
	public void setFloorage(int floorage) {
		this.floorage = floorage;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

}
