package com.example.UnoLibrary;

import com.example.UnoLibrary.Pedido.DBSingleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnoLibraryApplication {

	public static void main(String[] args) {
		if(!DBSingleton.conectar()){
			System.out.println(DBSingleton.getCon().getMensagemErro());
		}
		SpringApplication.run(UnoLibraryApplication.class, args);
	}
	
}
