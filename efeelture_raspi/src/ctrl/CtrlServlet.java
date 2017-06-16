package ctrl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import util.ResultUtil;

public class CtrlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String hname = request.getParameter("hname");
		String clevel = request.getParameter("clevel");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		map.put("resultCode", "999");

		String url = "/home/pi/ctrl/" + hname + "/" + hname + clevel + ".sh";
		// CtrlRW.runShell(url);
		try {
			Process process = Runtime.getRuntime().exec(url);
			InputStreamReader ir = new InputStreamReader(process.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			String line;
			while ((line = input.readLine()) != null)
				// System.out.println(line);
				input.close();
			ir.close();
			map.put("resultCode", "999");
			// String resultCode = ResultUtil.getCtrlSucceedCode();
			// out.write(resultCode);

			// read content
			map.put("content", "null");
			String resultCode = gson.toJson(map);
			out.write(resultCode);
		} catch (IOException e) {
			String resultCode = ResultUtil.getCtrlErrorCode();
			out.write(resultCode);
			e.printStackTrace();
		}

	}
}
