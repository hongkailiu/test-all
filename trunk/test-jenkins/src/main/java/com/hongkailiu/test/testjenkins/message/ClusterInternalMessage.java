package com.hongkailiu.test.testjenkins.message;

import java.io.Serializable;

/**
 * This interface standardizes how the application
 * communicates with its own cluster actor via Ask
 * method (to initiate a message send to other
 * members primarily via payload).
 */
public interface ClusterInternalMessage extends Serializable {

    /**
     * @return the message content
     */
    Object getMessageContent();

}
