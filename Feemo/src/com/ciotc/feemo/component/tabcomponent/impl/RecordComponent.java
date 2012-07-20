package com.ciotc.feemo.component.tabcomponent.impl;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;

import com.ciotc.feemo.component.tabcomponent.ChangeInfo;
import com.ciotc.feemo.component.tabcomponent.TabComponent;
import com.ciotc.feemo.component.tabcomponent.impl.RecordModel.Status;
import com.ciotc.feemo.util.ActionConstants;
import com.ciotc.feemo.util.I18N;
import com.ciotc.feemo.util.USBLock;
import com.ciotc.feemo.util.Util;
import com.ciotc.teemo.usbdll.USBDLL;
import static com.ciotc.feemo.util.I18N.*;

public class RecordComponent extends TabComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 记录新建的录制影片数
	 */
	private static int counter = 0;

	public RecordComponent() {
		model = new RecordModel();
		model.addChangeListener(this);

		view = new RecordView();
		setLayout(new BorderLayout());
		add(view);

		model.addChangeListener(view);

		this.title = I18N.getString("TabComponent.title") + (++counter);
	}

	public void play() {
		((RecordModel) model).play();
	}

	public void pause() {
		((RecordModel) model).pause();
	}

	public void stop() {
		((RecordModel) model).stop();
	}

	public void restore() {
		((RecordModel) model).restore();
	}

	public void save() {
		((RecordModel) model).save();
	}

	@Override
	public void open() {
		super.open();
		firePropertyChange(ActionConstants.RECORD_COMPONENT_OPEN, null, this);
	}

	@Override
	public void close() {
		super.close();
		RecordModel rm = (RecordModel) model;
		rm.closeDirectly();
		firePropertyChange(ActionConstants.RECORD_COMPONENT_CLOSE, null, this);
	}

	@Override
	public void triggerClose() {
		synchronized (USBLock.LOCK) {
			USBDLL.clearButton1Info();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		ChangeInfo info = (ChangeInfo) e.getSource();
		if (info.getTag().equals(ActionConstants.DATA_COLLECT_STATUS)) {
			firePropertyChange(ActionConstants.RECORD_COMPONENT_STATUS, null, info.getObject());

			Status status = (Status) info.getObject();

			if (status == Status.STOP) {
				Object[] options = { getString("RecordComponent.save"), getString("RecordComponent.notSave") };
				int response = JOptionPane.showOptionDialog(this, getString("RecordComponent.isSaveMoive"), getString("Feemo"), JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (response == 0) {

					RecordDoc rdoc = (RecordDoc) doc;
					String path = Util.chooseFile(this, ".");

					if (path != null && rdoc.saveDataToFile(path)) {
						save();
						JOptionPane.showMessageDialog(this, getString("RecordComponent.saveSuccess"), getString("Feemo"), JOptionPane.PLAIN_MESSAGE);
					} else
						JOptionPane.showMessageDialog(this, getString("RecordComponent.saveSuccess"), getString("Feemo"), JOptionPane.PLAIN_MESSAGE);
				}
			}

		}

	}

	public void triggerOpen() {
		((RecordModel) model).triggerOpen();
	}
}