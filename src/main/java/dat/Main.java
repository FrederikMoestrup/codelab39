package dat;

import dat.config.HibernateConfig;
import dat.controller.PoemController;
import dat.daos.PoemDAO;
import dat.entities.Poem;
import dat.enums.PoemType;
import io.javalin.Javalin;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("poems");

        PoemDAO poemDAO = new PoemDAO(emf);



        Javalin app = Javalin.create((config -> {
            config.router.contextPath = "/poems";
            config.bundledPlugins.enableRouteOverview("/routes");
        }));
        app.start(7777);


        PoemController.getAllPoems(app, poemDAO);
        PoemController.getPoem(app, poemDAO);
        PoemController.createPoem(app, poemDAO);
        PoemController.deletePoem(app, poemDAO);
        PoemController.updatePoem(app, poemDAO);





        /*
        poemDAO.createPoem(new Poem(PoemType.KEVIN_RED_HAIR,
                "Kevin med det røde hår,\n" +
                        "Lyser op, hvor end han går.\n" +
                        "Han er noget helt for sig,\n" +
                        "Som ild, der danser let og fri.",
                "chatgpt", "Kevin: Ildens Glød" ));

        poemDAO.createPoem(new Poem(PoemType.KEVIN_RED_HAIR,
                "Hans hår som flammer, klar og rød,\n" +
                        "Et fyrtårn, hvor han står og tråd.\n" +
                        "Kevin lyser uden tvivl,\n" +
                        "Som solens skarpe morgenhyl.",
                "chatgpt", "Kevin: Fyrtårnet"));

        poemDAO.createPoem(new Poem(PoemType.KEVIN_RED_HAIR,
                "Rødt som aftensolen skær,\n" +
                        "Kevin går, og folk de ser.\n" +
                        "Farven brænder i hans sjæl,\n" +
                        "Ingen anden er så hel.",
                "chatgpt", "Kevin: Aftensol"));

        poemDAO.createPoem(new Poem(PoemType.KEVIN_RED_HAIR,
                "Kevin bærer ildens skær,\n" +
                        "Med rødt hår, han lyser her.\n" +
                        "Vinden blæser gennem strå,\n" +
                        "Hver en lås som flamme slår.",
                "chatgpt", "Kevin: Ildens Skær"));

        poemDAO.createPoem(new Poem(PoemType.KEVIN_RED_HAIR,
                "I solen glimter Kevin klart,\n" +
                        "Hans røde hår er helt apart.\n" +
                        "Med farver stærke som rubin,\n" +
                        "Går han verden blidt forbi.",
                "chatgpt", "Kevin: Glimt af Rubin"));
        */
    }
}