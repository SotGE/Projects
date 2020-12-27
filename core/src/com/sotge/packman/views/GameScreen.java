package com.sotge.packman.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.sotge.packman.models.BadlogicModel;
import com.sotge.packman.utils.UI;

public class GameScreen implements Screen {

    public static float deltaCff;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TextureAtlas textureAtlas;
    private UI ui;

    private BadlogicModel badlogicModel;

    @Override
    public void show() {
        batch = new SpriteBatch();

        badlogicModel = new BadlogicModel(textureAtlas.findRegion("0"),0, 0, 4f, 4f * (256 / 256));

        ui = new UI();
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        deltaCff = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        badlogicModel.Draw(batch);
        batch.end();

        ui.draw();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height / width;
        camera = new OrthographicCamera(20f, 20f * aspectRatio);
        camera.zoom = 1.0f;
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        ui.dispose();
    }
}
