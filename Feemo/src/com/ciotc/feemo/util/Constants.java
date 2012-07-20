package com.ciotc.feemo.util;

public class Constants {

	/**
	 * 程序缩放比例
	 */
	public static final float WIDTH_RATE = 0.7f;
	public static final float HEIGHT_RATE = 0.7f;

	/**
	 * 图标大小
	 */
	public static final int ICON_WIDTH = 24;
	public static final int ICON_HEIGHT = 24;

	/**
	 * 状态栏的高
	 */
	public static final int STATUS_BAR_HEIGHT = 15;
	
	/**
	 * 手柄连接检测周期,单位ms
	 */
	public static final int HANDLE_CHECK_PERIOD = 1000;
	/**
	 * 按键1连接检测周期,单位ms
	 */
	public static final int BUTTON1_CHECK_PERIOD = 10;
	/**
	 * 按键2连接检测周期,单位ms
	 */
	public static final int BUTTON2_CHECK_PERIOD = 10;
	
	/**
	 * 配置的存放路径
	 */
	public static final String SETTINGS_PATH = ".feemo_settings";
	
	/**
	 * 传感器的宽(传感器点数):52
	 */
	public static final int  SENSOR_WIDTH = 52;
	
	/**
	 * 传感器的长(传感器点数):44
	 */
	public static final int  SENSOR_HEIGHT = 44;
	
	/**
	 * 传感器总点数
	 */
	public static final int SENSOR_NUM = SENSOR_WIDTH*SENSOR_HEIGHT;
	
	/**
	 * 绘制与控件的边界
	 */
	public static final int COMPONENT_GAP = 2;
}