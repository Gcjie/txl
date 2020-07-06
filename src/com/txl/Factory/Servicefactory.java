package com.txl.Factory;

import com.txl.service.GroupingService;
import com.txl.service.LinkmanService;
import com.txl.service.OwnService;
import com.txl.service.UserService;
import com.txl.serviceImpl.GroupingServiceImpl;
import com.txl.serviceImpl.LinkmanServiceImpl;
import com.txl.serviceImpl.OwnServiceImpl;
import com.txl.serviceImpl.UserServiceImpl;

public class Servicefactory {
	public static UserService getUserServiceInstance() {
		return new UserServiceImpl();
	}
	
	public static LinkmanService getLinkmanServiceInstance() {
		return new LinkmanServiceImpl();
	}
	
	public static GroupingService getGroupingServiceInstance() {
		return new GroupingServiceImpl();
	}
	
	public static OwnService getOwnServiceInstance() {
		return new OwnServiceImpl();
	}
}
