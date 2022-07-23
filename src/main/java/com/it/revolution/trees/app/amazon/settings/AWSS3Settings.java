package com.it.revolution.trees.app.amazon.settings;

import com.it.revolution.trees.app.common.AbstractSettings;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

@Data
@Configuration
@EqualsAndHashCode(callSuper = true)
@ConfigurationProperties(prefix = "amazon.s3")
public class AWSS3Settings extends AbstractSettings {

    @NotNull
    private Bucket bucket;

}
