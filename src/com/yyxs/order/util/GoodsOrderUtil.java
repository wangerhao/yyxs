package com.yyxs.order.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 商品订单工具类
 * @author power
 */
public class GoodsOrderUtil {
	
	private static Logger log = Logger.getLogger(GoodsOrderUtil.class);

	/**
	 * 获取当前时间
	 */
	public static String currentTime(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * log日志
	 * @param message
	 * @param t
	 */
	public static void log(Object message, Throwable t){
		log.error(message, t);
	}

	public static void log(String string) {
		log.info(string);
	}
}
