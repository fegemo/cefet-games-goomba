package br.cefetmg.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author fegemo
 */
public class Goomba {
    
    Animation animacaoDireita, animacaoEsquerda, animacaoTras, animacaoFrente;
    Animation animacaoCorrente;
    TextureRegion quadroCorrente;
    float tempoDaAnimacao;
    float x, y;
    Vector2 velocidade;
    
    public Goomba(Texture spriteSheet) {
        TextureRegion[][] goombaFrames = TextureRegion.split(spriteSheet, 21, 24);
        animacaoFrente = new Animation(0.075f, new TextureRegion[] {
            goombaFrames[0][0], 
            goombaFrames[0][1],
            goombaFrames[0][2],
            goombaFrames[0][3],
            goombaFrames[0][4],
        });
        animacaoFrente.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        animacaoDireita = new Animation(0.075f, new TextureRegion[] {
            goombaFrames[1][0], 
            goombaFrames[1][1],
            goombaFrames[1][2],
            goombaFrames[1][3],
            goombaFrames[1][4],
        });
        animacaoDireita.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        animacaoTras = new Animation(0.075f, new TextureRegion[] {
            goombaFrames[2][0], 
            goombaFrames[2][1],
            goombaFrames[2][2],
            goombaFrames[2][3],
            goombaFrames[2][4],
        });
        animacaoTras.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        animacaoEsquerda = new Animation(0.075f, new TextureRegion[] {
            goombaFrames[3][0], 
            goombaFrames[3][1],
            goombaFrames[3][2],
            goombaFrames[3][3],
            goombaFrames[3][4],
        });
        animacaoEsquerda.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);        
        animacaoCorrente = animacaoFrente;
        tempoDaAnimacao = 0;
        quadroCorrente = animacaoCorrente.getKeyFrame(tempoDaAnimacao);
        velocidade = new Vector2();
    }
    
    private void mantemNaTela() {
        if (x + quadroCorrente.getRegionWidth() > Gdx.graphics.getWidth()) {
            x = Gdx.graphics.getWidth() - quadroCorrente.getRegionWidth();
        } else if (x < 0) {
            x = 0;
        }
        if (y + quadroCorrente.getRegionHeight() > Gdx.graphics.getHeight()) {
            y = Gdx.graphics.getHeight() - quadroCorrente.getRegionHeight();
        } else if (y < 0) {
            y = 0;
        }
    }
    
    public void update() {
        tempoDaAnimacao += Gdx.graphics.getDeltaTime();

        velocidade.x = 0;
        velocidade.y = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            animacaoCorrente = animacaoEsquerda;
            velocidade.x = -1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            animacaoCorrente = animacaoDireita;
            velocidade.x = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            animacaoCorrente = animacaoTras;
            velocidade.y = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            animacaoCorrente = animacaoFrente;
            velocidade.y = -1;
        }
        
        if (!velocidade.isZero()) {
            velocidade.nor().scl(2);
            x += velocidade.x;
            y += velocidade.y;
            quadroCorrente = animacaoCorrente.getKeyFrame(tempoDaAnimacao);
            mantemNaTela();
        } else {
            quadroCorrente = animacaoCorrente.getKeyFrames()[2];
        }
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(quadroCorrente, x, y);
    }
}
