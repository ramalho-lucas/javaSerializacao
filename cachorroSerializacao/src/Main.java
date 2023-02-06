import com.digitalhouse.documento.model.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Cachorro> listCaoSave = new ArrayList<>();
        Cachorro pluto = new Cachorro(10, "Pluto");
        Cachorro muttley = new Cachorro(15, "Muttley");
        Cachorro coragem = new Cachorro(11, "Coragem");

        listCaoSave.add(pluto);
        listCaoSave.add(muttley);
        listCaoSave.add(coragem);

        //Comecando a salvar a lista no arquivo
        FileOutputStream arquivo1 = null;

        try {

            //cria o arquivo onde será escrito os bytes
            arquivo1 = new FileOutputStream("Cachorro.txt");

            //cria o objeto para escrever indicando onde sera escrito
            ObjectOutputStream caneta1 = new ObjectOutputStream(arquivo1);


            // escreve no arquivo os dados
            caneta1.writeObject(listCaoSave);

        } catch (Exception e) {
            e.printStackTrace();
        }


        // Comecando a recuperar as info (bytes)
        List<Cachorro> listCaoFind = new ArrayList<>();
        FileInputStream arquivo2;
        try {
            arquivo2 = new FileInputStream("Cachorro.txt");
            ObjectInputStream leitor = new ObjectInputStream(arquivo2);

            listCaoFind = (ArrayList) leitor.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Cachorro cachorro : listCaoFind) {
            System.out.println(cachorro.getNome() + " - " + cachorro.getIdade());
        }


//        //utilizando file writer
//        File diretorio = new File("C:\\Lucas\\java","cachorro,txt");
//
//        if(diretorio.isDirectory()){
//            for (Cachorro cachorro : listCaoSave){
//                try {
//                    FileWriter arquivo3 = new FileWriter("cachorro.txt",false);
//                    arquivo3.write(cachorro.getNome()+" "+cachorro.getIdade());
//                    arquivo3.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
   }
}