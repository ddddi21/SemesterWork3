package ru.itis.demo.services.implementations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.itis.demo.services.interfaces.TemplateMakerInterface;
import ru.itis.demo.services.interfaces.TemplateResolverInterface;

import java.util.Map;

@Service
public class TemplateMakerInterfaceImpl implements TemplateMakerInterface {
    private TemplateResolverInterface templateResolver;
    private Map<String,String> template;
    @Override
    public String makeTemplate(Map<String, String> params, String ftl) {
        template.putAll(params);
        return templateResolver.process(ftl, template);
    }


    public TemplateMakerInterfaceImpl(TemplateResolverInterface templateResolver,
                                      @Qualifier(value = "templateParameters") Map<String, String> templateParameters) {
            this.templateResolver = templateResolver;
            this.template = templateParameters;
        }
}
