package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		var wordCounts = new HashMap<String, Integer>(2048);
		var fileLoc = Paths.get("warpeace.txt");
		List<String> allLines = null;
		try {
			allLines = Files.readAllLines(fileLoc);
		} catch (IOException e) {
			System.out.println("error reading file");
		}
		if (allLines == null) {
			System.exit(-1);
		}
		for (var line : allLines) {
			var allwords = line.split(" ");
			for (var word : allwords) {
				word = word.replaceAll("\\p{Punct}", " ");
				var lowerCaseWord = word.toLowerCase(Locale.ROOT);
				if (wordCounts.containsKey(lowerCaseWord)) {
					var currentCount = wordCounts.get(lowerCaseWord);
					wordCounts.replace(lowerCaseWord, ++currentCount);
				}
				else{
					wordCounts.put(lowerCaseWord, 1);
				}

			}


		}
		var allWords = wordCounts.keySet();
		for(var word: allWords){
			System.out.println(word+ " : " + wordCounts.get(word));
		}
	}
}
