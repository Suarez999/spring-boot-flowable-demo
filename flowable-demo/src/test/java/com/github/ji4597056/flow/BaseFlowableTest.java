package com.github.ji4597056.flow;

import org.flowable.engine.HistoryService;
import org.flowable.engine.IdentityService;
import org.flowable.engine.ManagementService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;

/**
 * @author Jeffrey
 * @since 2017/07/26 16:03
 */
public class BaseFlowableTest {

    private static final String DATASOURCE_IP = "localhost";

    private static final String DATASOURCE_PORT = "3306";

    private static final String DATASOURCE_DB = "flowable";

    private static final String DATASOURCE_USERNAME = "root";

    private static final String DATASOURCE_PASSWORD = "root";

    private static final String DATASOURCE_DRIVER = "com.mysql.jdbc.Driver";

    protected static ProcessEngine processEngine;

    protected static RepositoryService repositoryService;

    protected static TaskService taskService;

    protected static RuntimeService runtimeService;

    protected static HistoryService historyService;

    protected static IdentityService identityService;

    protected static ManagementService managementService;

    static {
        // config
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
            .setJdbcUrl(
                "jdbc:mysql://" + DATASOURCE_IP + ":" + DATASOURCE_PORT + "/" + DATASOURCE_DB
                    + "?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&allowMultiQueries=true&useSSL=false&tinyInt1isBit=false")
            .setJdbcUsername(DATASOURCE_USERNAME)
            .setJdbcPassword(DATASOURCE_PASSWORD)
            .setJdbcDriver(DATASOURCE_DRIVER)
            .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        processEngine = cfg.buildProcessEngine();
        repositoryService = processEngine.getRepositoryService();
        taskService = processEngine.getTaskService();
        runtimeService = processEngine.getRuntimeService();
        historyService = processEngine.getHistoryService();
        identityService = processEngine.getIdentityService();
        managementService = processEngine.getManagementService();
    }
}
