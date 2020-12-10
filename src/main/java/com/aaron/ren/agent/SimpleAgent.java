package com.aaron.ren.agent;

import java.lang.instrument.Instrumentation;

public class SimpleAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("=========开始执行premain============");
        SimpleClassTransformer transformer = new SimpleClassTransformer();
        inst.addTransformer(transformer);

    }
}
