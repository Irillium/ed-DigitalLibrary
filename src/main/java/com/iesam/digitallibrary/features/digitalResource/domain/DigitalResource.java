package com.iesam.digitallibrary.features.digitalResource.domain;

public class DigitalResource {
    public final String name;
    public final String type;

    public DigitalResource(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
