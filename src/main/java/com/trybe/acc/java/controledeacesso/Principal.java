package com.trybe.acc.java.controledeacesso;

import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    ArrayList<Short> list = new ArrayList<Short>();

    short acessoEscolhido;
    acessoEscolhido = scanMenu();

    do {
      System.out.println("Entre com a idade:");

      String idade = scanner.next();
      short idadeDaPessoa = Short.parseShort(idade);

      list.add(idadeDaPessoa);

      if (idadeDaPessoa < 18) {
        System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        scanMenu();
      } else if (idadeDaPessoa >= 18 && idadeDaPessoa <= 49) {
        System.out.println("Pessoa adulta, catraca liberada!");
        scanMenu();
      } else {
        System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        scanMenu();
      }
    } while (acessoEscolhido == 1);

  }

  public static void showMenu() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Acessar o estabelecimento");
    System.out.println("2 - Finalizar sistema e mostrar relatório");
  }

  public static short scanMenu() {
    showMenu();

    String acesso = scanner.next();

    short acessoConfirmado = Short.parseShort(acesso);

    return acessoConfirmado;
  }
}
