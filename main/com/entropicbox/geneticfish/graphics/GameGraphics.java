package com.entropicbox.geneticfish.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.entropicbox.geneticfish.game.Game;
import com.entropicbox.geneticfish.member.Member;

public class GameGraphics extends JFrame implements KeyListener {

	private static final long serialVersionUID = 153512765282389707L;

	private Game game;
	public GameGraphics(Game game) {
		this.game = game;
		setSize(game.getWorld().getWidth(), game.getWorld().getHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
        addKeyListener(this);
	}

	public void render() {
		repaint();
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, game.getWorld().getWidth()+100, game.getWorld().getHeight()+100);
		
		//	Render the goal
        g.setColor(Color.RED);
        g.fillOval(game.getWorld().getGoal().getX(), game.getWorld().getGoal().getY(), 30, 30);
		//	Render the members
		
        g.setColor(Color.BLUE);
        for (int i = 0; i < game.getMemberPool().getNumMembers(); i++) {
        	Member member = game.getMemberPool().getMember(i);
        	g.fillRect(member.getX(), member.getY(), 10, 10);
        }
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		game.toggleSpeed();
	}
}
