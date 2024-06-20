package com.example;

import com.squareup.javapoet.*;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.util.Map;

public class GenerateFactory {
    private Filer filer;
    private Map<ClassName, Integer> input;

    public GenerateFactory(Filer filer, Map<ClassName, Integer> input) {
        this.filer = filer;
        this.input = input;
    }

    void generate() throws IOException {
        for (ClassName key : input.keySet()) {
            MethodSpec methodSpec = MethodSpec.methodBuilder("helloFrom" + key.simpleName())
                    .addModifiers(Modifier.PUBLIC)
                    .addStatement("System.out.println(\"Hello world class!\")")
                    .build();

            TypeSpec helloClass = TypeSpec.classBuilder("HelloWorldClass" + input.get(key))
                    .addModifiers(Modifier.PUBLIC)
                    .addMethod(methodSpec)
                    .build();
            JavaFile javaFile = JavaFile.builder(key.packageName(), helloClass)
                    .build();

            javaFile.writeTo(filer);
        }
    }
}
