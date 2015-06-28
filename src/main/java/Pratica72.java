
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import utfpr.ct.dainf.if62c.pratica.ContadorPalavras;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kiqdestro
 */
public class Pratica72 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        String caminho;
        
        System.out.println("Digite o caminho completo do arquivo: ");
        caminho = scanner.next();
        
        ContadorPalavras contador = new ContadorPalavras(caminho);
        
        HashMap<String, Integer> contaPalavras = contador.getPalavras(); 
        List lista = new LinkedList();

        lista.addAll(contaPalavras.values());
        Collections.sort(lista);
        Set<Map.Entry<String, Integer>> entries;

        BufferedWriter saida = new BufferedWriter(new FileWriter(caminho + ".out"));
        
        for (Object j: lista) {
        
            entries = contaPalavras.entrySet();
            for (Map.Entry<String, Integer> entry: entries) {
                    if(entry.getValue() == j) {
                        saida.write(entry.getKey() + "," + entry.getValue());
                        saida.newLine();
                        contaPalavras.remove(entry.getKey());
                        break;
                    }
                }

            }
            saida.close();
        
    }
}