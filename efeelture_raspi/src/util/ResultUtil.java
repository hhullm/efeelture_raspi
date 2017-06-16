package util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ResultUtil {

	public static String getCtrlSucceedCode() {
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		map.put("resultCode", "999");
		//upload data format not ture
		return gson.toJson(map);
	}
	public static String getCtrlErrorCode() {
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		map.put("resultCode", "2001");
		//upload data format not ture
		return gson.toJson(map);
	}
}
