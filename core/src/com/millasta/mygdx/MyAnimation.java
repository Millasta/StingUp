package com.millasta.mygdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Custom class for the use of 2D single graphics
 * @author Millasta
 * This include all the possibilities of the LibGDX Animation class.
 */
public class MyAnimation {

	private static int FRAME_COLS;
	private static int FRAME_ROWS;
	
	private Texture animationSheet;
	private TextureRegion[] animationFrames; 
	private Animation animation;
	
	private float stateTime;
	private boolean looping;
	
	/**
	 * @param assetPath : path of the sprite sheet
	 * @param frameCols : number of columns
	 * @param frameRows : number of rows
	 * @param frameDuration : duration of a frame in second
	 * @param looping : play mode of the animation
	 */
	MyAnimation(String assetPath, int frameCols, int frameRows, float frameDuration, boolean looping) {
		animationSheet = new Texture(Gdx.files.internal(assetPath));
		FRAME_COLS = frameCols;
		FRAME_ROWS = frameRows;
		TextureRegion[][] tmp = TextureRegion.split(animationSheet, animationSheet.getWidth()/FRAME_COLS, animationSheet.getHeight()/FRAME_ROWS);
		animationFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                animationFrames[index++] = tmp[i][j];
            }
        }
		animation = new Animation(frameDuration, animationFrames);
		stateTime = 0f;
		this.looping = looping;
	}
	
	/**
	 * Update stateTime of the animation
	 * @param deltaTime float : time since last update
	 */
	public void update(float deltaTime) {
		stateTime += deltaTime;
	}
	
	/**
	 * Reset stateTime of the animation
	 */
	public void reset() {
		stateTime = 0;
	}
	
	/**
	 * Update the frame duration
	 * @param frameDuration : the new duration
	 */
	public void setFrameDuration(float frameDuration) {
		animation.setFrameDuration(frameDuration);
	}
	
	/**
	 * @return TextureRegion : the current frame to draw
	 */
	public TextureRegion getCurrentFrame() {
		return animation.getKeyFrame(stateTime, looping);
	}
	
}
