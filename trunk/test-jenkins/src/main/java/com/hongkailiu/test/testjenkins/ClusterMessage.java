package com.hongkailiu.test.testjenkins;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by ehongka on 4/10/15.
 */
public class ClusterMessage implements Serializable {
    private static final long serialVersionUID = -2106724717783912064L;
    @Getter
    @Setter
    private String content;

    public ClusterMessage(String content) {
        this.content = content;
    }
}
