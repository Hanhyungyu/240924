package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter() {
		
	}
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	@Autowired
	public void setMemberPrinter(MemberPrinter printer) {
		this.printer=printer;
	}
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao=memberDao;
		this.printer=printer;
	}
	
	public void printAll() {
		Collection <Member> members=memberDao.selectAll();
		members.forEach(m->printer.print(m));
	}

}
