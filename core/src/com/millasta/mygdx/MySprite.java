package com.millasta.mygdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Custom class for the use of 2D single graphics
 * @author Millasta
 * This include all the possibilities of the LibGDX sprite class.
 */
public class MySprite {

	private Texture asset;
	private Sprite sprite;
	
	private float posX;
	private float posY;
	private float rotation;
	
	MySprite() {
		sprite = new Sprite();
	}
	MySprite(String assetPath) {
		asset = new Texture(Gdx.files.internal(assetPath));
		sprite = new Sprite(asset);
		posX = 0;
		posY = 0;
		rotation = 0;
		sprite.setPosition(posX, posY);
		sprite.setRotation(rotation);
	}
	MySprite(String assetPath, float x, float y) {
		asset = new Texture(Gdx.files.internal(assetPath));
		sprite = new Sprite(asset);
		posX = x;
		posY = y;
		rotation = 0;
		update();
	}
	MySprite(String assetPath, float x, float y, float width, float height) {
		asset = new Texture(Gdx.files.internal(assetPath));
		sprite = new Sprite(asset);
		posX = x;
		posY = y;
		sprite.setSize(width, height);
		rotation = 0;
		update();
	}
	
	public void draw(SpriteBatch batch) {
		this.sprite.draw(batch);
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	/**
	 * Set the current texture of the sprite, keeping the same size. Works with animations
	 * @param texture TextureRegion : the new texture to draw
	 */
	public void setTextureRegion(TextureRegion texture) {
		sprite.setRegion(texture);
	}
	
	/**
	 * Update following properties :
	 * 	Position
	 * 	Rotation
	 */
	public void update() {
		this.sprite.setPosition(posX, posY);
		this.sprite.setRotation(rotation);
	}
	
	/**
	 * Make a translation
	 * @param x float : horizontal translation
	 * @param y float : vertical translation
	 */
	public void move(float x, float y) {
		this.posX += x;
		this.posY += y;
	}
	
	/**
	 * Set the current position
	 * @param x float : new x position
	 * @param y float : new y position
	 */
	public void setPosition(float x, float y) {
		this.posX = x;
		this.posY = y;
	}
	
	/**
	 * Rotate the sprite
	 * @param rotation float : rotation in degrees
	 */
	public void rotate(float rotation) {
		this.sprite.rotate(rotation);
	}
}
