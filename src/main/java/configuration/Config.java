package configuration;

import configuration.models.EnvironmentModel;
import configuration.models.EnvironmentsModel;

public class Config {
    public String activeEnvironmentName;
    public EnvironmentsModel environments;

    public EnvironmentsModel getEnvironments() {
        return environments;
    }

    public EnvironmentModel getActiveEnvironment() {

        return environments.getEnvironments().get(activeEnvironmentName);
    }
}
