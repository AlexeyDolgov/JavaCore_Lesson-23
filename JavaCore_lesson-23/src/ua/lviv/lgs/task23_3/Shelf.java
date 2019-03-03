package ua.lviv.lgs.task23_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Shelf {

	ArrayList<Commodity> shelf = new ArrayList<Commodity>();

	Supplier<Commodity> getCommodity = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите название товара:");
		String name = scanner.next();
		System.out.println("Введите длинну товара, см:");
		int length = scanner.nextInt();
		System.out.println("Введите ширину товара, см:");
		int width = scanner.nextInt();
		System.out.println("Введите вес товара, г:");
		int weight = scanner.nextInt();

		return new Commodity(name, length, width, weight);
	};

	public Optional<Commodity> findCommodity() {
		Commodity commodityTyped = getCommodity.get();

		Predicate<Commodity> isEqual = commodity -> commodity.getName().equalsIgnoreCase(commodityTyped.getName())
				&& commodity.getLength() == commodityTyped.getLength()
				&& commodity.getWidth() == commodityTyped.getWidth()
				&& commodity.getWeight() == commodityTyped.getWeight();
		Optional<Commodity> commodityFound = shelf.stream().filter(isEqual).findFirst();

		return commodityFound;
	}

	public void addCommodity() {
		Commodity commodity = getCommodity.get();

		shelf.add(commodity);
		System.out.println("Товар " + commodity.toString() + " успешно добавлен на полку!");
	}

	public void removeCommodity() {
		Optional<Commodity> commodityFound = findCommodity();

		if (commodityFound.isPresent()) {
			shelf.remove(commodityFound.get());
			System.out.println("Товар " + commodityFound.get().toString() + " успешно удален с полки!");
		} else {
			System.out.println("Введенного товара нет на полке!");
		}
	}

	public void replaceCommodity() {
		Optional<Commodity> commodityFound = findCommodity();

		if (commodityFound.isPresent()) {
			System.out.println("Введите товар для замены:");
			Commodity newCommodityTyped = getCommodity.get();

			commodityFound.get().setName(newCommodityTyped.getName());
			commodityFound.get().setLength(newCommodityTyped.getLength());
			commodityFound.get().setWidth(newCommodityTyped.getWidth());
			commodityFound.get().setWeight(newCommodityTyped.getWeight());

			System.out.println("Введенный товар успешно заменен на " + commodityFound.get().toString() + "!");
		} else {
			System.out.println("Введенного товара нет на полке!");
		}
	}

	public void sortByName() {
		System.out.println("До сортировки товары располагались на полке в таком порядке:");
		shelf.forEach(System.out::println);

		System.out.println("После сортировки порядок расположения товаров на полке будет следующим:");
		shelf.stream().sorted(Comparator.comparing(Commodity::getName)).forEach(System.out::println);
	}

	public void sortByLength() {
		System.out.println("До сортировки товары располагались на полке в таком порядке:");
		shelf.forEach(System.out::println);

		System.out.println("После сортировки порядок расположения товаров на полке будет следующим:");
		shelf.stream().sorted(Comparator.comparing(Commodity::getLength)).forEach(System.out::println);
	}

	public void sortByWidth() {
		System.out.println("До сортировки товары располагались на полке в таком порядке:");
		shelf.forEach(System.out::println);
		
		System.out.println("После сортировки порядок расположения товаров на полке будет следующим:");
		shelf.stream().sorted(Comparator.comparing(Commodity::getWidth)).forEach(System.out::println);
	}

	public void sortByWeight() {
		System.out.println("До сортировки товары располагались на полке в таком порядке:");
		shelf.forEach(System.out::println);

		System.out.println("После сортировки порядок расположения товаров на полке будет следующим:");
		shelf.stream().sorted(Comparator.comparing(Commodity::getWeight)).forEach(System.out::println);
	}

	public void getCommodity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите порядковый номер товара на полке:");
		int i = scanner.nextInt();

		if (i < 0 || i > (shelf.size() - 1)) {
			System.out.println("Товара с таким порядковым номером нет на полке!");
		} else {
			System.out.println("Под порядковым номером " + i + " на полке находится " + shelf.get(i).toString());
		}
	}
}
