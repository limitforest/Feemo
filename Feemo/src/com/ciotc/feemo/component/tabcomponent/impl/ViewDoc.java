package com.ciotc.feemo.component.tabcomponent.impl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Pattern;

import com.ciotc.feemo.component.tabcomponent.Doc;
import com.ciotc.feemo.util.Constants;

public class ViewDoc extends Doc {

	int powa;
	int gain;
	int period;
	int frameLen;
	int[][] data;

	public ViewDoc(String path) {
		this.path = path;
		this.simplePath = path.substring(path.lastIndexOf(File.separator)+1);
		//System.out.println("path:"+path+"\n"+"simplePath:"+simplePath);
	}

	/**
	 * 数据格式
	 * 0、标识{@link FEEMO_FILE_TAG}(用于标识文件类型)<br>
	 * 1、帧数<br>
	 * 2、录制周期<br>
	 * 3、数据内容<br>
	 * 4、powa<br>
	 * 5、gain <br>
	 * 参考{@link RecordDoc#saveDataToFile(String) 保存文件的格式}
	 */
	boolean readDataFromFile() {
		RandomAccessFile rf = null;
		try {
			rf = new RandomAccessFile(path, "r");
			String tag = rf.readUTF();
			if (!tag.equals(Constants.FEEMO_FILE_TAG)) {
				return false;
			}

			frameLen = rf.readInt();
			period = rf.readInt();

			data = new int[frameLen][Constants.SENSOR_NUM];
			for (int i = 0; i < frameLen; i++) {
				for (int j = 0; j < Constants.SENSOR_NUM; j++) {
					data[i][j] = rf.readInt();
				}
			}
			powa = rf.readInt();
			gain = rf.readInt();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (rf != null) {
				try {
					rf.close();
				} catch (IOException e1) {
					e1.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 兼容Teemo的文件
	 * @return
	 */
	boolean readDataFromTeemoFile() {
		return false;
	}

	public int[] getSelectedFrame(int frameIndex) {
		return data[frameIndex];
	}

	public int getFrameLen() {
		return frameLen;
	}
	
	/**
	 * 
	 * @param in
	 * @param x
	 *                坐标轴上的横坐标
	 * @param y
	 *                坐标轴上的纵坐标
	 * @return
	 */
	public int getForceinXY(int in, int x, int y) {
		int i = Constants.SENSOR_HEIGHT * x + y;
		int d = data[in][i];
		return d;
	}
}
