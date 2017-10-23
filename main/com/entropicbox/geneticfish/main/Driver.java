package com.entropicbox.geneticfish.main;
import com.entropicbox.geneticfish.game.Game;
import com.entropicbox.geneticfish.game.GameFactory;


public class Driver {

	public static void main(String[] args) {
		Game game = GameFactory.buildRandomGame();
		game.run();
	}
}
