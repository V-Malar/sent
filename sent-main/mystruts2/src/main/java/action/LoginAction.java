package action;

import java.sql.Connection;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionutility.ConnectionUtility;
import login.ILoginDAO;
import login.LoginDTO;

public class LoginAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ILoginDAO login;
		LoginDTO l;
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		if(uname.equals("mathew")) {
			return "login.success";
		}
		else{
			return "login.register";
		}
	}
}
