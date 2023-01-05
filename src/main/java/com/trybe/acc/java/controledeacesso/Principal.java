package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Principal {
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<Integer>();

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
          list.add(1);
        } else if (idadeDaPessoa >= 18 && idadeDaPessoa <= 49) {
          System.out.println("Pessoa adulta, catraca liberada!");
          list.add(2);
        } else {
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
          list.add(3);
        }
      } else {
        short crianca = 0;
        short adulto = 0;
        short idoso = 0;
        
        for(short i = 0; i < list.size(); i++) {
          if(list.get(i) == 1) {
            crianca += 1;
          } else if(list.get(i) == 2) {
            adulto += 1;
          } else {
            idoso += 1;
          }
        }
        
        float total = crianca + adulto + idoso;
        
        NumberFormat df = NumberFormat.getCurrencyInstance(Locale.US);
        ((DecimalFormat)df).applyPattern("0.0#");
        
        System.out.println("----- Quantidade -----");
        System.out.println("menores: " + crianca);
        System.out.println("adultas: " + adulto);
        System.out.println("a partir de 50: " + idoso);
        System.out.println("----- Percentual -----");
        System.out.println("menores: " + df.format(crianca*100 / total).toString() + "%");
        System.out.println("menores: " + df.format(adulto*100 / total).toString() + "%");
        System.out.println("menores: " + df.format(idoso*100 / total).toString() + "%");
        System.out.println("TOTAL: " + (crianca + adulto + idoso));
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
