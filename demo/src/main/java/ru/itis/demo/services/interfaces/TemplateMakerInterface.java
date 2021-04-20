package ru.itis.demo.services.interfaces;

import java.util.Map;

public interface TemplateMakerInterface {
    String makeTemplate(Map<String, String> params, String ftl);

}
