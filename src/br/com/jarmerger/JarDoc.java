package br.com.jarmerger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class JarDoc {

	public static void main(String[] args) {
		String buildDir = args[0];
		String jarName = args[1];
		File manifest = new File(buildDir + "/META-INF/MANIFEST.MF");
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			try {
				reader = new BufferedReader(new FileReader(manifest));
				writer = new PrintWriter(new BufferedWriter(new FileWriter(buildDir + "/merged_jars.info", true)));
				
				writer.append(String.format("\n----------- Jar: %s \n\n", jarName));
				
				String line;
				while((line = reader.readLine()) != null){
					writer.append(line).append("\n");
				}
			} finally {
				if (reader != null) reader.close();
				if (writer != null) {
					writer.flush();
					writer.close();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
