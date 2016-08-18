package br.cefetmg.games;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {

    private SpriteBatch batch;
    private Goomba goomba;
    private Texture map;

    @Override
    public void create() {
        batch = new SpriteBatch();
    }

    public void update() {
    }
    
    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        update();
        
        batch.begin();
        // desenhos são realizados aqui
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
