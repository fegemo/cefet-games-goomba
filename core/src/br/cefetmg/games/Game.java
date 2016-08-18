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
        goomba = new Goomba(new Texture("goomba-spritesheet.png"));
        map = new Texture("map.png");
    }

    public void update() {
        goomba.update();
    }
    
    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        update();
        
        batch.begin();
        batch.draw(map, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        goomba.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
