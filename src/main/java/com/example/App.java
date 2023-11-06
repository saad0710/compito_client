package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        
        try {
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String risposta = new String();
            Scanner scanner = new Scanner(System.in);
            
            do {
                System.out.println("Inserisci la nota da memorizzare, digita LISTA per visualizzare le note salvate o digita ESCI per uscire");
                System.out.print("Nota: ");
                out.writeBytes(scanner.nextLine() + '\n');
                risposta = in.readLine();
                switch(risposta)
                {
                    case "LISTA":
                        System.out.println(in.readLine());
                    break;
                    default:
                        System.out.println("nota inserita");
                    break;
                }
            } while (!risposta.equals("ESCI"));
            System.out.println("Disconnesso...");
            scanner.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Qualcosa è andato storto, chiusura del client...");
            System.exit(1);
        }


    }
}
