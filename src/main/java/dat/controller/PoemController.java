package dat.controller;

import dat.daos.PoemDAO;
import dat.entities.Poem;
import io.javalin.Javalin;

public class PoemController {

    public static void getAllPoems(Javalin app, PoemDAO poemDAO) {
        app.get("/", ctx -> ctx.json(poemDAO.getAllPoems()));
    }

    public static void getPoem(Javalin app, PoemDAO poemDAO) {
        app.get("/poem/{id}", ctx -> {
            long id = Long.parseLong(ctx.pathParam("id"));
            ctx.json(poemDAO.getPoem(id));
        });

    }

    public static void createPoem(Javalin app, PoemDAO poemDAO) {
        app.post("/poem", ctx -> {
            poemDAO.createPoem(ctx.bodyAsClass(Poem.class));
            ctx.status(201);
        });
    }

    public static void deletePoem(Javalin app, PoemDAO poemDAO) {
        app.delete("/poem/{id}", ctx -> {
            long id = Long.parseLong(ctx.pathParam("id"));
            poemDAO.deletePoem(poemDAO.getPoem(id));
            ctx.status(204);
        });
    }

    public static void updatePoem(Javalin app, PoemDAO poemDAO) {
        app.put("/poem/{id}", ctx -> {
            long id = Long.parseLong(ctx.pathParam("id"));
            Poem poem = poemDAO.getPoem(id);
            poem.setPoem(ctx.bodyAsClass(Poem.class).getPoem());
            poem.setAuthor(ctx.bodyAsClass(Poem.class).getAuthor());
            poem.setTitle(ctx.bodyAsClass(Poem.class).getTitle());
            poemDAO.updatePoem(poem);
            ctx.status(204);
        });
    }

}
