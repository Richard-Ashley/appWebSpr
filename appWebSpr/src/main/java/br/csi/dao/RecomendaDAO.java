
package br.csi.dao;


import br.csi.modelo.Filme;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RecomendaDAO {
    
     public ArrayList<Filme> recomenda(int id) throws IOException, TasteException {


        //pega o arquivo que tem as avaliaÃ§Ãµes
        File file = new File("C:\\Users\\Sylvia Ashley pc\\Downloads\\appWebSpr\\appWebSpr\\src\\main\\java\\br\\csi\\dao\\ml-100k.csv");

        DataModel model = new FileDataModel(file);

        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

        UserNeighborhood neiborhood =
                new NearestNUserNeighborhood(100, similarity, model);

        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neiborhood, similarity);

        //lista dos objetos recomendados
        List<RecommendedItem> recommendations = recommender.recommend(id, 5);


        System.out.println("recomendations: " + id);

        //pega o arquivo que tem os nomes e os ids dos objetos
        File file1 = new File("C:\\Users\\Sylvia Ashley pc\\Downloads\\appWebSpr\\appWebSpr\\src\\main\\webapp\\WEB-INF\\jsp\\list.txt");


        System.out.println("arquivo dos nomes: \n");

        ArrayList<Filme> filmes = new ArrayList<>();


        Scanner scanner = new Scanner(file1);


        //varre o arquivo dos nomes para identificar o id e o nome e separalos
        while (scanner.hasNextLine()){

            String line = scanner.nextLine();

            StringTokenizer st = new StringTokenizer(line);

            String idItem = st.nextToken("|");

            String titulo = st.nextToken("|");

            //add o titulo e o id no objeto filme e depois seta pra lista de filmes
            Filme filme = new Filme();
            filme.setItemID(idItem);
            filme.setTitulo(titulo);
            filmes.add(filme);

        }



        ArrayList<Filme> filmesRecomendados = new ArrayList<>();

        //esses dois for sÃ£o para varrer a lista de recomendaÃ§Ãµes e a lista dos id e nomes
         for (int j=0; j < 5; j++){

            for (int i = 0; filmes.size() > i; i++){

                //aqui compara se os ids sÃ£o iguais ele add na variavel filmerecomendado o id e o nome do filme
              if (filmes.get(i).getItemID().equals(String.valueOf(recommendations.get(j).getItemID()))){
                  System.out.println("if do filmes.get: ");
                  Filme filmeRecomendado = new Filme();
                  filmeRecomendado.setItemID(String.valueOf(recommendations.get(j).getItemID()));
                  filmeRecomendado.setTitulo(filmes.get(i).getTitulo());

                  filmesRecomendados.add(filmeRecomendado);
              }
            }
        }

        System.out.println(filmesRecomendados);
        //}

        return filmesRecomendados;
    }

    public String
    salvaNota(Filme filme) throws IOException {

        FileWriter fw = new FileWriter("C:\\Users\\Sylvia Ashley pc\\Downloads\\appWebSpr\\appWebSpr\\src\\main\\java\\br\\csi\\dao\\ml-100k.csv", true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(filme.getIdUsuario()+","+filme.getItemID()+","+filme.getNota());
        pw.flush();
        pw.close();

        return "ok";
    }
}
