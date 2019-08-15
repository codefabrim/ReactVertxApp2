package react;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

public class BackendVerticle extends AbstractVerticle {

    //TOOD  Expose a message Service over HTTP


    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        Route messageRoute = router.get("/api/message");
        messageRoute.handler(rc -> { rc.response().end("Hello React from Vert.x");
            });

        router.get().handler(StaticHandler.create());


        vertx.createHttpServer()
                .requestHandler(router)
                .listen(8075);




    }


    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new BackendVerticle());
    }
}
