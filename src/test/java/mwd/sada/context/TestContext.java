package mwd.sada.context;

import java.util.concurrent.ConcurrentHashMap;

public class TestContext {
	private static ConcurrentHashMap<String, Object> contextBag = new ConcurrentHashMap<>();

	public static ConcurrentHashMap<String, Object> getContextBag() {
		return contextBag;
	}
}
