package ru.itis.demo.services.interfaces;

import java.util.Map;

public interface TemplateResolverInterface {
    String process(String name, Map<String, String> root);
}
