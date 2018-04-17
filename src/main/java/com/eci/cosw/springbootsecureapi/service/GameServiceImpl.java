package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Game;
import com.eci.cosw.springbootsecureapi.model.Seller;

import java.util.ArrayList;
import java.util.List;


public class GameServiceImpl implements GameService {

    private List<Game> game = new ArrayList<Game>();


  //  @Autowired
    public GameServiceImpl() {

    }
    public void inicializar(){
        Seller s;
        //Ingreso juego 1
        List<Comment> comm = new ArrayList<Comment>();
        List<Seller> seller1 = new ArrayList<Seller>();
        /*  game.add(new Game("MarioBros","El juego describe las aventuras de los hermanos Mario y Luigi, personajes que ya protagonizaron el arcade Mario Bros. de 1983.",game.size()+1,5,seller1,"https://imagenes.es.sftcdn.net/es/scrn/58000/58588/super-mario-bros-3-07-535x535.png",comm));
        game.get(0).setComments("Exelente juego lo recomiendo para PSP","Laura Sanchez",5,1,game.get(0));
        game.get(0).setSellers("$359.900","www.Nintendo.com",1,game.get(0));
        game.get(0).setSellers("$500 000","listado.mercadolibre.com.mx/juegos-de-mario-bros-gratis",2,game.get(0));
        //Ingreso juego 2
        List<Comment> comm1 = new ArrayList<Comment>();
        List<Seller> seller2 = new ArrayList<Seller>();
        game.add(new Game("Need for speed","videojuego de carreras de acción creada por Electronic Arts y actualmente desarrollada por Ghost Games. La serie se centra en las carreras callejeras ilícitas y, en general, les da el papel a los jugadores de completar varios tipos de carreras",6,4,seller2,"http://www.nintenderos.com/wp-content/uploads/2017/06/need-for-speed-payback-2017610212541_1.jpg",comm1));
        game.get(1).setComments("Uno de los mejores juegos que ah sacado Electronic Arts","Jessica Sanchez",comm1.size(),5,game.get(1));
        game.get(1).setComments("Muy regular los graficos","Carol meneses",comm1.size(),3,game.get(1));
        game.get(1).setSellers("$ 159.000","https://videojuegos.mercadolibre.com.co/videojuegos/juegos-ps4/need-for-speed/",1,game.get(1));*/
           }

    @Override
    public Game getGame(String name) {
        Game getGam=null;
        for(int i=0;i<game.size()-1;i++){
            if( game.get(i).getName().equals(name)) getGam= game.get(i);

        }
        return getGam;
    }

    @Override
    public List<Game> getTopGame() {
        List<Game> getGam=null;
        for(int i=0;i<game.size()-1;i++){
          //  if( game.get(i).getRate()>=4) getGam.add(game.get(i));

        }
        return getGam;
    }


    @Override
    public void newComment(Comment comment) {
      //  game1.setComments(comment, user,id,rate,game1);

    }

    @Override
    public Game createGame(Game game) {
        return null;
    }
}
