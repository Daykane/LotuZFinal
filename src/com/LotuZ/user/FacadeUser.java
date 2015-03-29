package com.LotuZ.user;

import java.sql.SQLException;

import com.LotuZ.FacadeBL;
import com.LotuZ.PersistKit;

import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.activityLeader.bl.ActivityLeaderManager;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.contributor.bl.ContributorManager;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.member.bl.MemberManager;
import com.LotuZ.user.user.bl.ListUser;
import com.LotuZ.user.user.bl.User;
import com.LotuZ.user.user.bl.UserManager;

public class FacadeUser {
	

	private static ActivityLeaderManager activityLeaderManager;
	private static ContributorManager contributorManager;
	private static UserManager userManager;
	private static MemberManager memberManager;


	
	public static void init(PersistKit kit){
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
	
	public static Contributor getContributor(String mail) throws SQLException, UserNotFoundException{
		return contributorManager.getContributor(mail);
	}
	
	public static Contributor getContributorEvents(String idContributor) throws SQLException, UserNotFoundException{
		return contributorManager.getContributorEvents(idContributor);
	}
	
	public static ActivityLeader getActivityLeader(String mail) throws SQLException, UserNotFoundException{
		return activityLeaderManager.getActivityLeader(mail);
	}
	
	public static void updateMember(Member member) throws SQLException, UserNotFoundException, ClassNotFoundException{
		memberManager.updateMember(member);
	}
	
	public static void updateUser(User user) throws SQLException, UserNotFoundException, ClassNotFoundException{
		userManager.updateUser(user);
	}
	
	public static void deleteMember(int idMember) throws SQLException, UserNotFoundException, ClassNotFoundException{
		memberManager.deleteMember(idMember);
	}
	
	public static void deleteUser(User user) throws SQLException, UserNotFoundException, ClassNotFoundException{
		userManager.deleteUser(user);
	}
	
	public static ListUser getMembers() throws SQLException {
		return userManager.getMembers();
	}
	
	public static ListUser getContributors() throws SQLException {
		return userManager.getContributors();
	}
	
	public static ListUser getLeaders() throws SQLException {
		return userManager.getLeaders();
	}
	
	public static void deleteLeader(String idLeader) throws SQLException, UserNotFoundException, ClassNotFoundException{
		activityLeaderManager.deleteActivityLeader(idLeader);
	}
	
	public static void deleteContributor(String idContributor) throws SQLException, UserNotFoundException, ClassNotFoundException{
		contributorManager.deleteContributor(idContributor);
	}

}
