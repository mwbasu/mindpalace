package org.appr;

public class Employee {
	private String eid, name, email, contact, address, doj, man_id, password;
	private int man_r;

	public Employee(String eid, String name, int man_r) {
		super();
		this.eid = eid;
		this.name = name;
		this.man_r = man_r;
	}

	public int getMan_r() {
		return man_r;
	}

	public void setMan_r(int man_r) {
		this.man_r = man_r;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getMan_id() {
		return man_id;
	}

	public void setMan_id(String man_id) {
		this.man_id = man_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee(String eid, String name, String email, String contact, String address, String doj, String man_id,
			String password) {
		super();
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.doj = doj;
		this.man_id = man_id;
		this.password = password;
	}

	public Employee() {
		super();
	}

	public Employee(String eid, String name, String email, String contact, String address, String doj, String man_id) {
		super();
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.doj = doj;
		this.man_id = man_id;
	}
	public Employee(String eid, String name, String email, String contact, String address, String doj) {
		super();
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.doj = doj;	
	}
	
	
}
