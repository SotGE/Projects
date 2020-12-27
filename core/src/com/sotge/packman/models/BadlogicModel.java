package com.sotge.packman.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sotge.packman.controllers.BadlogicController;

public class BadlogicModel extends GameObject {

    private BadlogicController badlogicController;

    public BadlogicModel(TextureRegion textureRegion, float x, float y, float width, float height) {
        super(textureRegion, x, y, width, height);
        badlogicController = new BadlogicController(bounds);
    }

    @Override
    public void Draw(SpriteBatch batch) {
        super.Draw(batch);
        badlogicController.handle();
    }
}
