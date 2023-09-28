package com.birds.nns;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Bird extends Block{
    private double acceleration;
    private double speed;
    private double headAngle;
    private double tapAcceleration;

    private long score;
    public static int radius;

    private boolean isDead;


//    public Bird() {
//        acceleration = 0;
//        speed = 0;
//        headAngle = 0;
//        tapAcceleration = 10;
//    }
//
//    public Bird(int acceleration, int speed, float headAngle, int tapAcceleration) {
//        this.acceleration = acceleration;
//        this.speed = speed ;
//        this.headAngle = headAngle;
//        this.tapAcceleration = tapAcceleration;
//    }

    public Bird(double x, double y) {
        super(x, y);
        acceleration = 0.3;
        speed = 0;
        headAngle = 0;
        tapAcceleration = 10;
        radius=10;
        isDead = false;
        score = 0;
    }

    public void Tap (){
        this.speed = -8;
    }

    @Override
    void Render(GraphicsContext context){
        if (y<=0 || y>=context.getCanvas().getHeight()) GameOver();
        if (isDead) {
            context.setFill(Color.PURPLE);
            context.setFont(Font.font(50));
            context.fillText("You LOSE " + score, 100,100);
            return;
        }

        context.setFill(Color.YELLOW);
        context.fillOval(x-radius, y-radius, radius*2, radius*2);

        context.setFont(Font.font(25));
        context.fillText(String.valueOf(score), 60,30);
    }
//    @Override
    void UpdateState(Pipe pipe){
        if (pipe.x<(this.x+this.radius))
            if (this.y>(pipe.y+pipe.holeSize) || this.y<(pipe.y-pipe.holeSize)) {
                GameOver();
                return;
            }
        speed += acceleration;
        y += speed;

        if (!isDead) score++;
    }

    void GameOver(){
        isDead=true;
    }

}
