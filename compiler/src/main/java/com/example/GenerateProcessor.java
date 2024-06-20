package com.example;

import com.squareup.javapoet.ClassName;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SupportedAnnotationTypes("com.example.GenerateHelloClass")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class GenerateProcessor extends AbstractProcessor {

    private Filer filer;
    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Map<ClassName, Integer> res = new HashMap<>();
        int counter = 0;
        for (Element annotatedElement : roundEnvironment.getElementsAnnotatedWith(GenerateHelloClass.class)) {
            TypeElement typeElement = (TypeElement) annotatedElement;
            ClassName className = ClassName.get(typeElement);
            res.put(className, counter++);
        }
        try {
            new GenerateFactory(filer, res).generate();
        } catch (IOException e) {
            error(e.getMessage());
        }

        return true;
    }

    private void error(String message) {
        messager.printMessage(Diagnostic.Kind.ERROR, message);
    }
}

