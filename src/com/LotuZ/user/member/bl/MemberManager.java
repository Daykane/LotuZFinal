package com.LotuZ.user.member.bl;

import java.sql.SQLException;

import com.LotuZ.PersistKit;



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
		member = member.load(idMember);
		return member;
	}
	
	

	/**
	 * @param idContributor
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public void deleteMember(int idMember) throws SQLException, ClassNotFoundException {
		Member member = pkit.createMember();
		member.setIdMember(idMember);
		member.delete();
	}
	
	
	
	/**
	 * @param member1
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void updateMember(Member member1) throws SQLException, ClassNotFoundException {
		Member member = pkit.createMember();
		member.update(member1);
	}
}