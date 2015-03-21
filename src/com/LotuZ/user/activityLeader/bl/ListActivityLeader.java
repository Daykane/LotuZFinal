package com.LotuZ.user.activityLeader.bl;

import java.sql.Connection;
import java.util.List;

import com.LotuZ.user.User;

public abstract class ListActivityLeader {

	private List<User> listActivityLeader;

	public ListActivityLeader(List<User> listActivityLeader) {
		super();
		this.listActivityLeader = listActivityLeader;
	}

	public ListActivityLeader() {
		super();
	}

	public List<User> getListActivityLeader() {
		return listActivityLeader;
	}

	public void setListActivityLeader(List<User> listActivityLeader) {
		this.listActivityLeader = listActivityLeader;
	}


	public abstract ListActivityLeader load();
	
}
