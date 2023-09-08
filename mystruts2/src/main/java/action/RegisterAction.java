package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionutility.ConnectionUtility;
import login.ILoginDAO;
import login.LoginDTO;
import register.IRegisterDAO;
import register.RegisterDTO;

public class RegisterAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		IRegisterDAO register;
		RegisterDTO r;
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String password = request.getParameter("upass");
		String age = request.getParameter("age");
		try {
			register = new IRegisterDAO();
			r = new RegisterDTO();
			r.setName(uname);
			r.setEmail(email);
			r.setAge(age);
			r.setPassword(password);
			register.updateRegister(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "lang.success";
	}
}
