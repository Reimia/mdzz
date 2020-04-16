package com.reimia.camundaTest;

import org.camunda.bpm.client.ExternalTaskClient;

public class testWorker {
    public static void main(String[] args) {

        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000)
                .build();

        client.subscribe("测试")
                .lockDuration(1000)
                .handler((externalTask, externalTaskService) -> {
                    //业务
                    System.out.println("这是一个业务");
                    //测试
                    String item = (String)externalTask.getVariable("item");
                    Long amount = (Long)externalTask.getVariable("amount");
                    System.out.println("item is:"+item + " & amount is:" + amount);
                    externalTaskService.complete(externalTask);
                })
                .open();
    }

}
