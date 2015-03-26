package com.LotuZ.user;

import java.util.List;
import java.sql.SQLException;

import com.LotuZ.FacadeBL;
import com.LotuZ.PersistKit;
import com.LotuZ.activity.ActivityManager;
import com.LotuZ.inscription.InscriptionManager;
import com.LotuZ.login.LoginManager;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.product.ProductManager;
import com.LotuZ.product.category.bl.CategoryManager;
import com.LotuZ.user.activityLeader.bl.ActivityLeaderManager;
import com.LotuZ.user.contributor.bl.ContributorManager;
import com.LotuZ.user.contributor.bl.ListContributor;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.member.bl.MemberManager;
import com.LotuZ.user.user.bl.User;
import com.LotuZ.user.user.bl.UserManager;

public class FacadeUser {
	
	private static LoginManager loginManager;
	private static InscriptionManager inscriptionManager;
	private static ActivityLeaderManager activityLeaderManager;
	private static ContributorManager contributorManager;
	private static UserManager userManager;
	private static MemberManager memberManager;


	
	public static void init(PersistKit kit){
		loginManager = new LoginManager(kit);
		inscriptionManager = new InscriptionManager(kit);
		activityLeaderManager = new ActivityLeaderManager(kit);
		contributorManager = new ContributorManager(kit);
		userManager = new UserManager(kit);
		memberManager = new MemberManager(kit);
	}
	public static void login(String mail, String password) throws SQLException, UserNotFoundException{
		FacadeBL.loginUser(mail,password);
	}
	
	public static User getUser(String mail) throws SQLException, UserNotFoundException{
		return userManager.getUser(mail);
	}
	
	public static Member getMember(String mail) throws SQLException, UserNotFoundException{
		return memberManager.getMember(mail);
	}
	
	public static void updateMember(Member member) throws SQLException, UserNotFoundException, ClassNotFoundException{
		memberManager.updateMember(member);
	}
	
	public static void updateUser(User user) throws SQLException, UserNotFoundException, ClassNotFoundException{
		userManager.updateUser(user);
	}
	
	public static void deleteMember(Member member) throws SQLException, UserNotFoundException, ClassNotFoundException{
		memberManager.deleteMember(member);
	}
	
	public static void deleteUser(User user) throws SQLException, UserNotFoundException, ClassNotFoundException{
		userManager.deleteUser(user);
	}
	


}
