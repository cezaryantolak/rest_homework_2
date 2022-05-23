package configuration;

import configuration.models.EnvironmentModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class AppProperties {
    Logger logger = LoggerFactory.getLogger(AppProperties.class);
    YamlReader yamlReader = new YamlReader();
    public EnvironmentModel activeEnv;

    public AppProperties() {
        setSystemPropertiesFromYamlEnvironment();
    }

    public static AppProperties getInstance() {
        return AppProperties.AppPropertiesSingleton.INSTANCE;
    }

    private void setSystemPropertiesFromYamlEnvironment() {
        EnvironmentModel activeEnv = yamlReader.getConfig().getActiveEnvironment();
        if (activeEnv == null) {
            throw new IllegalArgumentException("Couldn't find environment");
        }
        Map<String, Object> environmentProperties = activeEnv.getProperties();
        for (Map.Entry entry : environmentProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
            logger.info("Loaded environment property: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
        logger.info("Loaded environment properties total: {}", environmentProperties.size());
    }

    private static class AppPropertiesSingleton {
        private static final AppProperties INSTANCE = new AppProperties();
    }

}
