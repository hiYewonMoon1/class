package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.domain.MemberDTO;
import member.service.MemberLoginService;


@WebServlet("/todo/login")
public class LoginController extends HttpServlet {
	
	MemberLoginService loginService;
	
	public LoginController() {
		this.loginService = new MemberLoginService();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("LoginController... doGet()...");
		
		request.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("LoginController... doPost()...");
		
		// 사용자가 입력한 id/pw 받아서 인증 처리
		String mid = request.getParameter("mid");
		String pw = request.getParameter("pw");
		String reid = request.getParameter("reid");
		System.out.println("reid: " + reid);
		
		
		// 현재 session 정보 획득
		HttpSession session = request.getSession();
		
		// 인증처리 : id/pw 같은 문자열일 때 login

		// id, pw 값을 서비스로 전달 -> dao 전달해서 memeberDTO 객체 반환받음
		MemberDTO member = loginService.login(mid, pw);
		
		
		// dto가 null이면 회원 아님/ null이 아니면 회원 -> 로그인 처리
		if(member!=null) {
			// 회원 인증 -> HttpSession 객체에 정보 저장
			// 저장된 회원 정보는 회원이 로그인 했다는 판단 기준으로 사용
			session.setAttribute("loginInfo", member);
			
			// reid 값이 on이면 쿠키 저장
			if(reid!=null && reid.equals("on")) {
				Cookie cookie = new Cookie("reid", mid);
				cookie.setMaxAge(60*60*24*180);	// 초단위
				cookie.setPath("/");
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("reid", "aa");
				cookie.setMaxAge(0);
				cookie.setPath("/");
			
				response.addCookie(cookie);
			}
			
			response.sendRedirect("/app/index.jsp");
			return;
			
		} else {
			System.out.println("인증 실패");
			response.sendRedirect("/app/login");
		}
		
	}
}