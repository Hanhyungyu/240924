package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangepasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;
import spring.MemberPrinter;
import spring.MemberListPrinter;

@Configuration
public class AppConf2 {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private MemberPrinter memberPrinter;
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao);
	}
	@Bean
	public ChangepasswordService changePwdSvc() {
		ChangepasswordService pwdSvc=new ChangepasswordService();
		pwdSvc.setMemberDao(memberDao);
		return pwdSvc;
	}
	
	@Bean 
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao, memberPrinter);
		
	}
	@Bean MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter=new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setPrinter(memberPrinter);
		return infoPrinter;
	}
	@Bean 
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter=new VersionPrinter();
		versionPrinter.setMajorVerison(5);
		versionPrinter.setMinorVerison(0);
		return versionPrinter;
		
	}
}
