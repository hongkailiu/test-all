package com.hongkailiu.test.testjenkins;

import static java.util.logging.Level.INFO;
import hudson.Extension;
import hudson.XmlFile;
import hudson.model.Saveable;
import hudson.model.listeners.SaveableListener;

import java.io.File;
import java.util.logging.Logger;

@Extension
public class MySaveableListener extends SaveableListener {

	private static final Logger LOG = Logger.getLogger(MySaveableListener.class
			.getName());

	/** {@inheritDoc} */
	@Override
	public void onChange(final Saveable o, final XmlFile file) {
		// LOG.log(FINEST, "My In onChange for {0}", o);
		if (isInteresting(o, file)) {
			LOG.log(INFO, "My (interesting) toString In onChange for {0}", file.toString());
//			try {
//				LOG.log(INFO, "My asString In onChange for {0}",
//						file.asString());
//			} catch (IOException e) {
//				LOG.log(SEVERE, "My getStackTrace In onChange for {0}",
//						e.getStackTrace());
//			}
		} else {
			LOG.log(INFO, "My (not interesting) toString In onChange for {0}",
					file.toString());
		}

	}

	private boolean isInteresting(Saveable o, XmlFile file) {
//		LOG.log(INFO, "My o.getClass().toString() In onChange for {0}",
//				o.getClass().toString());
//		if (o instanceof TopLevelItem) {
//			return true;
//		}
//		return false;
		return isConfigSystem(file) ||  isSystemLog(file);
	}

	private boolean isSystemLog(XmlFile file) {
		return SystemLogFileFilter.accepts(new File(file.toString()));
	}

	private boolean isConfigSystem(XmlFile file) {
		return GlobalConfigurationFileFilter.accepts(new File(file.toString()));
	}

}
