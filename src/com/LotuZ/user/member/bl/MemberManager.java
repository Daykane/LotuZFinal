package com.LotuZ.user.member.bl;

import java.sql.SQLException;

import com.LotuZ.PersistKit;
import com.LotuZ.user.user.bl.User;


/**
 * @author Ludo
 *
 */
public class MemberManager {

	private PersistKit pkit;
	
	/**
	 * 
	 * @param kit
	 */
	public MemberManager(PersistKit kit){
		this.pkit=kit;
	}
	
	/**
	 * @param idContributor
	 * @return
	 * @throws SQLException
	 */
	public Member getMember(String idMember) throws SQLException {
		Member member = pkit.createMember();
		member.load(idMember);
		return member;
	}
	
	

	/**
	 * @param idContributor
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public void deleteMember(Member member1) throws SQLException, ClassNotFoundException {
		Member member = pkit.createMember();
		member.delete(member1);
	}
	
	public void updateMember(Member member1) throws SQLException, ClassNotFoundException {
		Member member = pkit.createMember();
		member.update(member1);
	}
}