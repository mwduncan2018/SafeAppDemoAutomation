package mwd.sada.dataprovider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import mwd.sada.testdata.Product;
import mwd.sada.testdata.Root;
import mwd.sada.testdata.WatchListEntry;

public class JsonTestData {
	private static final String jsonTestDataPath = ConfigurationProperties.getTestDataPath();
	private static Root root = null;
	private static List<Product> products;
	private static List<WatchListEntry> watchListEntries;

	public static List<Product> getProducts() {
		initialize();
		return products;
	}

	public static Product getProduct(String manufacturer, String model) {
		initialize();
		products.stream().filter(x -> x.getModel() == model && x.getManufacturer() == manufacturer)
				.collect(Collectors.toList());
		if (products.size() == 0)
			return null;
		return products.get(0);
	}

	public static List<WatchListEntry> getWatchListEntries() {
		initialize();
		return watchListEntries;
	}

	public static WatchListEntry getWatchListEntry(String manufacturer, String model) {
		initialize();
		watchListEntries.stream().filter(y -> y.getModel() == model && y.getManufacturer() == manufacturer)
				.collect(Collectors.toList());
		if (watchListEntries.size() == 0)
			return null;
		return watchListEntries.get(0);
	}

	public static void initialize() {
		if (root == null) {
			root = unmarshalJson();
			products = extractProducts(root);
			watchListEntries = extractWatchListEntries(root);
		}
	}

	public static List<Product> extractProducts(Root root) {
		List<Product> productList = new ArrayList<Product>();
		for (Product rootProduct : root.getProducts()) {
			Product product = new Product();
			product.setManufacturer(rootProduct.getManufacturer());
			product.setModel(rootProduct.getModel());
			product.setNumberInStock(rootProduct.getNumberInStock());
			product.setPrice(rootProduct.getPrice());
			productList.add(product);
		}
		return productList;
	}

	public static List<WatchListEntry> extractWatchListEntries(Root root) {
		List<WatchListEntry> watchEntryList = new ArrayList<WatchListEntry>();
		for (WatchListEntry rootWatchListEntry : root.getWatchListEntries()) {
			WatchListEntry watchListEntry = new WatchListEntry();
			watchListEntry.setManufacturer(rootWatchListEntry.getManufacturer());
			watchListEntry.setModel(rootWatchListEntry.getModel());
			watchEntryList.add(watchListEntry);
		}
		return watchEntryList;
	}

	public static Root unmarshalJson() {
		Root root = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			File file = new File(jsonTestDataPath);
			root = objectMapper.readValue(file, Root.class);
		} catch (IOException e) {
			System.out.println("An exception occurred while extracting JSON test data");
			e.printStackTrace();
		}
		return root;
	}

}
