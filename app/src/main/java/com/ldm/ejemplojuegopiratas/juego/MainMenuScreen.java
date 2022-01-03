package com.ldm.ejemplojuegopiratas.juego;

import android.media.MediaPlayer;

import java.util.List;
import com.ldm.ejemplojuegopiratas.Juego;
import com.ldm.ejemplojuegopiratas.Graficos;
import com.ldm.ejemplojuegopiratas.Input.TouchEvent;
import com.ldm.ejemplojuegopiratas.Pantalla;
import com.ldm.ejemplojuegopiratas.androidimpl.AndroidJuego;

public class MainMenuScreen extends Pantalla {
    public MainMenuScreen(Juego juego) {
        super(juego);
    }

    @Override
    public void update(float deltaTime) {
        Graficos g = juego.getGraphics();
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        juego.getInput().getKeyEvents();

        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 0, g.getHeight() - 64, 64, 64)) {
                    Configuraciones.sonidoHabilitado = !Configuraciones.sonidoHabilitado;
                    if(Configuraciones.sonidoHabilitado) {
                        Assets.pulsar.play(100);
                        Assets.homeaudio.play();
                    } else {
                        Assets.homeaudio.pause();
                    }
                }
                if(inBounds(event, 112, 220, 92, 42) ) {
                    juego.setScreen(new PantallaJuego(juego));
                    if(Configuraciones.sonidoHabilitado)
                    {Assets.pulsar.play(100);
                    }
                    return;
                }
                if(inBounds(event, 90, 220 + 42, 132, 42) ) {
                    juego.setScreen(new PantallaMaximasPuntuaciones(juego));
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(100);
                    return;
                }
                if(inBounds(event, 112, 220 + 84, 95, 42) ) {
                    juego.setScreen(new PantallaAyuda(juego));
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(100);
                    return;
                }
            }
        }
    }

    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.bardofondo, 0, 0);
        g.drawPixmap(Assets.logo, 67, 40);
        g.drawPixmap(Assets.jugar, 112, 220);
        g.drawPixmap(Assets.puntuaciones, 90, 262);
        g.drawPixmap(Assets.ayuda, 112, 304);
        if(Configuraciones.sonidoHabilitado)
            g.drawPixmap(Assets.botonvolumen, 0, 416);
        else
            g.drawPixmap(Assets.botonsilencio, 0, 416);
    }

    @Override
    public void pause() {
        Configuraciones.save(juego.getFileIO());
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}

