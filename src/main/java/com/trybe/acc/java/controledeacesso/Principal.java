package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    ArrayList<String> list = new ArrayList<String>();

    short acessoEscolhido;

    do {
      acessoEscolhido = scanMenu();
      
      if(acessoEscolhido != 1 && acessoEscolhido != 2) {
        System.out.println("Entre com uma opção válida");
        continue;
      }

      if (acessoEscolhido == 1) {
        System.out.println("Entre com a idade:");

        String idade = scanner.next();
        short idadeDaPessoa = Short.parseShort(idade);

        if (idadeDaPessoa < 18) {
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (idadeDaPessoa >= 18 && idadeDaPessoa <= 49) {
          System.out.println("Pessoa adulta, catraca liberada!");
        } else {
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        }
      } else {
        System.out.println("Finalizado");
      }
    } while (acessoEscolhido != 2);
    scanner.close();
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
