package tk.hongkailiu.test.dropwizard;

import com.google.common.collect.ImmutableMultimap;
import io.dropwizard.servlets.tasks.Task;
import lombok.extern.log4j.Log4j;

import java.io.PrintWriter;

/**
 * Created by ehongka on 12/22/15.
 */
@Log4j public class MyTestTask extends Task {

    private int timeoutSeconds;

    public MyTestTask(int timeoutSeconds) {
        super("mytest");
        this.timeoutSeconds = timeoutSeconds;
    }

    // curl -X POST http://localhost:9001/tasks/mytest
    @Override public void execute(ImmutableMultimap<String, String> parameters, PrintWriter output)
        throws Exception {
        log.info("============ execute ============");
    }
}
