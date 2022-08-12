package com.example.lse_bot.model;

public class Component {

    String componentId;
    String parameters;

    public Component(String componentId, String parameters) {
        this.componentId = componentId;
        this.parameters = parameters;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}

