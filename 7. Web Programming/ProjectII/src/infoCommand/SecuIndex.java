package infoCommand;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import infoModel.SecuIndexDao;

public class SecuIndex implements ICommand{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String year = request.getParameter("year");
		System.out.println(year);
		SecuIndexDao sidao = new SecuIndexDao();
		JSONArray array = sidao.getSecuIndex(year);
		
		
		
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        // JSON 데이터 전송
        response.getWriter().write(array.toString());
		
		
		
	}
}