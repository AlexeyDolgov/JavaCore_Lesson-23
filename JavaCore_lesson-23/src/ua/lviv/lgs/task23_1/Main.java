package ua.lviv.lgs.task23_1;

import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		Supplier<Integer> menu = () -> {
			System.out.println();
			System.out.println("Введите 1, чтобы добавить фракцию в Верховную Раду");
			System.out.println("Введите 2, чтобы удалить фракцию из Верховной Рады");
			System.out.println("Введите 3, чтобы вывести все фракции в Верховной Раде");
			System.out.println("Введите 4, чтобы очистить введенную фракцию");
			System.out.println("Введите 5, чтобы вывести введенную фракцию");
			System.out.println("Введите 6, чтобы добавить депутата в фракцию");
			System.out.println("Введите 7, чтобы удалить депутата из фракции");
			System.out.println("Введите 8, чтобы вывести список взяточников");
			System.out.println("Введите 9, чтобы вывести самого большого взяточника");

			Scanner scanner = new Scanner(System.in);
			int menuChoise = scanner.nextInt();
			
			return menuChoise;
		};

		while (true) {
			switch (menu.get()) {

			case 1: {
				SupremeCouncil.getInstance().addDeputyGroup();
				break;
			}

			case 2: {
				SupremeCouncil.getInstance().removeDeputyGroup();
				break;
			}

			case 3: {
				SupremeCouncil.getInstance().getAllDeputyGroups();
				break;
			}

			case 4: {
				SupremeCouncil.getInstance().clearDeputyGroup();
				break;
			}

			case 5: {
				SupremeCouncil.getInstance().getDeputyGroup();
				break;
			}

			case 6: {
				SupremeCouncil.getInstance().addDeputyToDeputyGroup();
				break;
			}

			case 7: {
				SupremeCouncil.getInstance().removeDeputyFromDeputyGroup();
				break;
			}

			case 8: {
				SupremeCouncil.getInstance().getBribeTakersFromDeputyGroup();
				break;
			}

			case 9: {
				SupremeCouncil.getInstance().getLargestBribeTakerFromDeputyGroup();
				break;
			}

			default: {
				System.out.println("Введите число от 1 до 9!");
				break;
			}
			}
		}
	}
}
