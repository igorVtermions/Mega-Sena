package MegaSena;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Project {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] chosenNumber = new int[7];

		for (int i = 0; i < 7; i++) {
			boolean valid = false;
			do {
				System.out.print("Escolha o " + (i + 1) + "º número (0 a 100): ");
				if (scanner.hasNextInt()) {
					int number = scanner.nextInt();
					if (number >= 0 && number <= 100) {
						chosenNumber[i] = number;
						valid = true;
					} else {
						System.out.println("Número fora do intervalo de 0 a 100. Tente novamente.");
					}
				} else {
					System.out.println("Entrada inválida. Digite um número inteiro.");
					scanner.next();
				}
			} while (!valid);
		}

		int[] sortNumbers = sort();

		System.out.println("Números sorteados: " + Arrays.toString(sortNumbers));

		int success = countSucess(chosenNumber, sortNumbers);

		awardDetermine(success);

		scanner.close();
	}

	private static int[] sort() {
		Random random = new Random();
		int[] sortNumber = new int[7];
		for (int i = 0; i < 7; i++) {
			sortNumber[i] = random.nextInt(101);
		}
		return sortNumber;
	}

	private static int countSucess(int[] chosenNumber, int[] sortNumber) {
		int sucess = 0;
		for (int chosen : chosenNumber) {
			for (int draft : sortNumber) {
				if (chosen == draft) {
					sucess++;
					break;
				}
			}
		}
		return sucess;
	}

	private static void awardDetermine(int sucessNumber) {
		System.out.println("Você acertou " + sucessNumber + " números.");

		switch (sucessNumber) {
		case 5:
			System.out.println("Parabéns! Você ganhou 10 mil reais.");
			break;
		case 6:
			System.out.println("Parabéns! Você ganhou 50 mil reais.");
			break;
		case 7:
			System.out.println("Parabéns! Você ganhou 200 mil reais.");
			break;
		default:
			System.out.println("Infelizmente, você não ganhou nenhum prêmio.");
		}
	}
}
