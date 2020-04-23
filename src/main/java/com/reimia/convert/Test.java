package com.reimia.convert;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Test {

	public static IEvent convertCommandToEvent(ICommand command){
		return (IEvent) JSONObject.toJSON(command);
	}

	public static <T extends AbsCommand> T convertEventToCommand(AbsEvent event , Class<T> commandClass){
		String s = JSONObject.toJSONString(event);
		return JSONObject.parseObject(s,commandClass);
	}

	public static void main(String[] args) {
		AllotmentStartEvent allotmentStartEvent = new AllotmentStartEvent();
		allotmentStartEvent.setContextID("1111");
		allotmentStartEvent.setDevice(new AllotmentLineDevice());
		allotmentStartEvent.setOrder(JSONArray.parseArray("[]"));
		AllotmentStartCommand allotmentStartCommand = convertEventToCommand(allotmentStartEvent,AllotmentStartCommand.class);
		System.out.println(1);
	}
}
