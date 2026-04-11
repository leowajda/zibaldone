package com.tutego.ch_03.externalConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// spring will register the bean depending on the profile
@Profile("demo")
@ShellComponent
public class FsCommands {

    private static final Logger logger = LoggerFactory.getLogger(FsCommands.class);

    @Autowired
    private Environment env;

    // @Value("${com.tutego.homepage}")
    private final String homePage;

    // @Value("${com.tutego.number-of-seminars}")
    private final int numberOfSeminars;

    private final int meaningOfLife;

    private final List<Server> list;

    private final Map<String, Server> map;

    public FsCommands(
            TutegoConfigurationProperties configurationProperties,
            @Value("${com.tutego.meaning-of-life:#{40+1+1}}") /* evaluates a default value */ int meaningOfLife) {
        logger.info("Bean gets registered only with the 'demo' profile");
        this.list = configurationProperties.list();
        this.map = configurationProperties.map();
        this.meaningOfLife = meaningOfLife;
        this.homePage = configurationProperties.homepage();
        this.numberOfSeminars = configurationProperties.numberOfSeminars();
    }

    @ShellMethod
    public String getHome() {
        return env.getProperty("user.home", "unknown");
    }

    @ShellMethod
    public int getMeaningOfLife() {
        return this.meaningOfLife;
    }

    @ShellMethod
    public int getNumberOfSeminars() {
        return this.numberOfSeminars;
    }

    @ShellMethod
    public String getHomePage() {
        return this.homePage;
    }

    @ShellMethod
    public List<Server> getList() {
        return new ArrayList<>(this.list);
    }

    @ShellMethod
    public Map<String, Server> getMap() {
        return new HashMap<>(this.map);
    }
}
