package pagesTest;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/main/java/steps")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@rar")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "FALSE")

public class CucumberRunnerTest {
}

