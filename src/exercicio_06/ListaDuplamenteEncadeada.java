package exercicio_06;

import exercicio_05.Funcionario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class ListaDuplamenteEncadeada {

    public static void main (String [] args){
     Funcionario funcionario=new Funcionario(12, "Jose", "1500", LocalDate.parse("02/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));
        Funcionario funcionario1=new Funcionario(12, "Jose", "1500", LocalDate.parse("02/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));
        Funcionario funcionario2=new Funcionario(12, "Jose", "1500", LocalDate.parse("02/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));
      Elemento e=new Elemento();
e.add(funcionario);
//e.add(funcionario1);
//e.add(funcionario2);
           }
}
