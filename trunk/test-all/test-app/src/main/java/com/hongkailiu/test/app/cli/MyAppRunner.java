package com.hongkailiu.test.app.cli;

import com.hongkailiu.test.app.util.SystemUtil;
import lombok.extern.log4j.Log4j;
import org.apache.commons.cli.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongkailiu on 2015-05-02.
 */
@Log4j public class MyAppRunner {

    public static final String MODULE_WORD_COUNT =
        com.hongkailiu.test.app.hadoop.mr.wordcount.WordCountJob.MODULE_NAME;

    public static final List<String> MODULE_LIST =
        new ArrayList<String>();

    static {
        MODULE_LIST.add(MODULE_WORD_COUNT);
    }

    private static final String MODULE = "module";
    private static final String APP_HOME = "app.home";
    /*private static final String LOG_FILENAME = "log.filename";*/

    private Options options;
    private CommandLine line;

    private String[] args;

    public void runApp(String[] args) {
        this.args = args;

        initEnvVars();
        createOptions();

        try {
            parseCommandLine(args);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Parsing failed.  Reason: " + e.getMessage());
        }

        interrogate();
        runApp();
    }

    private void initEnvVars() {
        String appHome = SystemUtil.getSystemProperty(APP_HOME);
        if (StringUtils.isEmpty(appHome)) {
            throw new IllegalArgumentException("app home is required: -Dapp.home=<appHome>");
        }
        AppEnv.setAppHome(appHome);
        log.info("appHome: " + appHome);
    }

    private void interrogate() {
        if ( line.hasOption("h")) {
            printHelp();
        }

        if (line.hasOption(MODULE)) {
            String module = line.getOptionValue(MODULE);
            AppEnv.setModule(module);
            log.info("module: " + module);
        } else {
            throw new IllegalArgumentException("module name is required");
        }
    }

    private void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("MyApp", options);
    }

    private void parseCommandLine(String[] args) throws ParseException {

        // create the parser
        CommandLineParser parser = new BasicParser();

        // parse the command line arguments
        line = parser.parse(options, args);

    }

    private void createOptions() {

        options = new Options();

        Option module =
            OptionBuilder.withArgName("MODULE").hasArg().withDescription("run the given module")
                .create("module");
        options.addOption(module);

        options.addOption("h", "help", false, "print help for the command.");
    }

    private void runApp() {

        if (!MODULE_LIST.contains(AppEnv.getModule())) {
            throw  new IllegalArgumentException("unknown module");
        }

        if (MODULE_WORD_COUNT.equalsIgnoreCase(AppEnv.getModule())) {
            log.info("jump into module: " + MODULE_WORD_COUNT);
            log.info("args: " + args);
            /* com.hongkailiu.test.app.hadoop.mr.wordcount.WordCountJob.main(args); */
        }
    }
}
