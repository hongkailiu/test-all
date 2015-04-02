package com.hongkailiu.test.testjenkins;

import static java.util.logging.Level.FINEST;
import hudson.Extension;
import hudson.XmlFile;
import hudson.model.Saveable;
import hudson.model.listeners.SaveableListener;

import java.util.logging.Logger;

@Extension
public class MySaveableListener extends SaveableListener {

    private static final Logger LOG = Logger.getLogger(MySaveableListener.class.getName());

    /** {@inheritDoc} */
    @Override
    public void onChange(final Saveable o, final XmlFile file) {
        LOG.log(FINEST, "My In onChange for {0}", o);
    }

}
