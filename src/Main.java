import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        List<String> staff= new ArrayList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "src/data/staff.txt"));
            String line = reader.readLine();
            while (line != null) {
                staff.add(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        File file = new File("src/index.html");

        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        System.out.print("<!doctype html>\n" +
                "<html lang=\"fr\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <title>Liste des agents</title>\n" +
                "  <link rel=\"stylesheet\" href=\"style.css\">\n" +
                "</head>\n" +
                "<body>\n" );
        Collections.sort(staff);
        for (String agent:staff) {
            System.out.println("<a href=\"carteAgent/"+ agent+".html\"><h2>"+agent+"</h2></a> ");
        }
        System.out.println("</body>\n" +
                "</html>\n"
        );
        try {
            Path path = Paths.get("src/carteAgent");
            Files.createDirectories(path);
        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }

        File tmp;
        Agent pers=new Agent();
        for (String agent:staff) {
            tmp = new File("src/carteAgent/"+agent+".html");
            stream = new PrintStream(tmp);
            System.setOut(stream);
            List<String> materiels=new ArrayList<>();
            try {
                reader = new BufferedReader(new FileReader("src/data/"+agent+".txt"));
                pers.setNom(reader.readLine());
                pers.setPrenom(reader.readLine());
                pers.setOccupation(reader.readLine());
                pers.setPassword(reader.readLine());
                reader.readLine();
                String line = reader.readLine();

                while (line != null) {
                    materiels.add(line);
                    // read next line
                    line = reader.readLine();
                }
                pers.setMateriel(materiels);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("<!doctype html>\n" +
                    "<html lang=\"fr\">\n" +
                    "<head>\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "  <title>Titre de la page</title>\n" +
                    "  <link rel=\"stylesheet\" href=\"style.css\">\n" +
                    "  <script src=\"script.js\"></script>\n" +
                    "</head>\n" +
                    "<body>\n" );

            System.out.println("<h3>Nom : "+pers.getNom() +"</h3>");
            System.out.println("<h3>Prenom : "+pers.getPrenom() +"</h3>");
            System.out.println("<h3>Occupation : "+pers.getOccupation() +"</h3>");
            System.out.println("<h3>Materiels : ");
            for (String materiel:materiels) {
                System.out.println("\t"+materiel+"|\n");
            }
            System.out.println("</h3>");

            System.out.println("</body>\n" +
                    "</html>");


        }



    }
}
