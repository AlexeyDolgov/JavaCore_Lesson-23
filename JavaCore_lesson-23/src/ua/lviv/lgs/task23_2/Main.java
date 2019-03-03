package ua.lviv.lgs.task23_2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {

		Set<ArbitrarilyClass> ac = new HashSet<ArbitrarilyClass>();
		Consumer<ArbitrarilyClass> addToHashSet = arbitrarilyClassItem -> ac.add(arbitrarilyClassItem);
		addToHashSet.accept(new ArbitrarilyClass("String1", 25));
		addToHashSet.accept(new ArbitrarilyClass("String4", 44));
		addToHashSet.accept(new ArbitrarilyClass("String3", 12));
		addToHashSet.accept(new ArbitrarilyClass("String2", 57));
		addToHashSet.accept(new ArbitrarilyClass("String5", 94));

		System.out.println("HashSet выводит элементы в случайном порядке");
		ac.forEach(System.out::println);

		Set<ArbitrarilyClass> ac1 = new LinkedHashSet<ArbitrarilyClass>();
		Consumer<ArbitrarilyClass> addToLinkedHashSet = arbitrarilyClassItem -> ac1.add(arbitrarilyClassItem);
		addToLinkedHashSet.accept(new ArbitrarilyClass("String1", 25));
		addToLinkedHashSet.accept(new ArbitrarilyClass("String4", 44));
		addToLinkedHashSet.accept(new ArbitrarilyClass("String3", 12));
		addToLinkedHashSet.accept(new ArbitrarilyClass("String2", 57));
		addToLinkedHashSet.accept(new ArbitrarilyClass("String5", 94));

		System.out.println();
		System.out.println("LinkedHashSet выводит элементы в порядке их добавления");
		ac1.forEach(System.out::println);

		Set<ArbitrarilyClass> ac2 = new TreeSet<ArbitrarilyClass>();
		Consumer<ArbitrarilyClass> addToTreeSet = arbitrarilyClassItem -> ac2.add(arbitrarilyClassItem);
		addToTreeSet.accept(new ArbitrarilyClass("String1", 25));
		addToTreeSet.accept(new ArbitrarilyClass("String4", 44));
		addToTreeSet.accept(new ArbitrarilyClass("String3", 12));
		addToTreeSet.accept(new ArbitrarilyClass("String2", 57));
		addToTreeSet.accept(new ArbitrarilyClass("String5", 94));

		System.out.println();
		System.out.println("TreeSet выводит элементы в порядке, переопределенном в Comparable (по умолчанию)");
		ac2.forEach(System.out::println);

		System.out.println();
		System.out.println("TreeSet выводит элементы в порядке, переопределенном в Comparator");
		ac2.stream().sorted(new ArbitrarilyClassIntegerComparator()).forEach(System.out::println);
	}
}
