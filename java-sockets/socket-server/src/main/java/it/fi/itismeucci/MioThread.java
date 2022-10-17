package it.fi.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MioThread extends Thread{
    Socket client;

    public MioThread(Socket client){
        this.client=client;
    }
    public void run(){
        BufferedReader in;
        try {
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        String recv = in.readLine();
        System.out.print("Stringa ricevuta: " + recv);
        String modifiedRecv = recv.toUpperCase();
        out.writeBytes(modifiedRecv + '\n');
        client.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
    
    }
}
