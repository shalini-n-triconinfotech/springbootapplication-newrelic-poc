package com.example.relic.lib;

import com.newrelic.api.agent.NewRelic;
import org.springframework.stereotype.Component;

@Component
public class NewRelicAttributes {
    public void generateCustomParameter(String key,String parameter)
    {
        NewRelic.addCustomParameter(key,parameter);
    }
}
