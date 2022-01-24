package it.cesarino.cesarinodeserializzazione;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class main {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
         //Esegue la deserializzazione
         File file = new File("src/main/java/it/cesarino/cesarinodeserializzazione/classe.xml"); //E' il percoso per la deserilizzazione
         XmlMapper xmlMapper = new XmlMapper();
         root value = xmlMapper.readValue(file, root.class);
         System.out.println("La Classe " + value.getClasse() + " " + value.getSpecializzazione() + " si trova nell'Aula " + value.getAula().getNome() + " ed è composta dai seguenti Studenti:"); //stampo a schermo il conentuo del file XML
         
         // Gli studenti che si trovano nel vettore
         for(int i = 0; i < value.getStudenti().size(); i++){
             System.out.println("- " + value.getStudenti().get(i).getCognome() + " " + value.getStudenti().get(i).getNome());
         }
 
         //Esegue la serializzazione


         xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); //Stampa delle stringhe
         xmlMapper.writeValue(new File("src/main/java/it/cesarino/cesarinodeserializzazione/classeAgg.xml"), value); //Serializzazione
         File newFile = new File("classeAgg.xml"); //creo nuovo file XML
         
         //Viene effettuata la serializzazione della stringa


         String xml = xmlMapper.writeValueAsString(value);
         System.out.println("\n" + xml);
     }
    
}
