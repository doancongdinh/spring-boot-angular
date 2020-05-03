package com.javainuse.crawler;

import com.javainuse.model.Chapter;
import com.javainuse.model.Comic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Crawler {
    private WebDriver driver;
    private String mainURL;

    public Crawler() {
        File file = new File("SpringBootHelloWorld-ang/src/main/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver" ,file.getAbsolutePath());
        this.driver = new ChromeDriver();
    }

    public void setMainURL(String url) {
        this.mainURL = url;
        this.driver.get(url);
    }

    public void close() {
        this.driver.close();
    }

    public Comic getAllChapterPerComic() {
        Comic comic = new Comic();
        comic.setName(driver.findElement(By.xpath("//*[@id=\"infor-box\"]/div[2]/h1")).getText());
        List<WebElement> webElementList = driver.findElements(By.xpath("//*[@id=\"manga-chapter\"]/span/a"));
        List<Chapter> chapters = webElementList.stream().map(item ->
           new Chapter(item.getText(), item.getAttribute("href"))
        ).collect(Collectors.toList());
        chapters.forEach(chapter -> {
            chapter.setChapterPageUrl(getAllComicPagesPerChapter(chapter.getChapterUrl(), chapter.getChapterNo()));
        });
        comic.setChapters(chapters);

        return comic;
    }

    public List<String> getAllComicPagesPerChapter(String url, String chapName) {
        try {
            this.setMainURL(url);
            List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"viewer\"]/img"));
            List<String> result = list.stream().map(e -> e.getAttribute("src")).collect(Collectors.toList());
            result.forEach(item -> {
                System.out.println(chapName + "," + item);
            });
            return result;
        } catch(Exception e) {
            e.getStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
