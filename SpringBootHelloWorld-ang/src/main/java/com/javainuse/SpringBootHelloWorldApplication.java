package com.javainuse;

import com.javainuse.crawler.Crawler;
import com.javainuse.model.Comic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHelloWorldApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
//		Crawler crawler = new Crawler();
//		crawler.setMainURL("http://truyentranhtuan.com/one-piece/");
//		Comic result = crawler.getAllChapterPerComic();
//		System.out.println(result.toString());
//		crawler.close();
	}

}
