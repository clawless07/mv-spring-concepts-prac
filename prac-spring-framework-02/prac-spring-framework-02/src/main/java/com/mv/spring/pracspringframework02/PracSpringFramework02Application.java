package com.mv.spring.pracspringframework02;

import com.mv.spring.pracspringframework02.game.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PracSpringFramework02Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PracSpringFramework02Application.class, args);

//		GamingConsole game = new MarioGamingConsole();
//		GameRunner runner = new GameRunner(game);
//		runner.run();
//		game = new SuperContraGamingConsole();
//		runner = new GameRunner(game);
//		runner.run();
//		GamingConsole game = new PacManGame();
//		GameRunner runner = new GameRunner(game);

		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
	}

}
