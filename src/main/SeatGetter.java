package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SeatGetter {

	public static void main(String[] args) throws IOException {
		// Make a URL to the web page
		URL url = new URL("https://ntst.umd.edu/soc/search?courseId=enee200&sectionId=&termId=201408&_openSectionsOnly=on&courseLevelFilter=ALL&classStartTime=&_classDays=on&teachingCenter=ALL");

		// Get the input stream through URL Connection
		URLConnection con = url.openConnection();
		InputStream is =con.getInputStream();

		// Once you have the Input Stream, it's just plain old Java IO stuff.

		// For this case, since you are interested in getting plain-text web page
		// I'll use a reader and output the text content to System.out.

		// For binary content, it's better to directly read the bytes from stream and write
		// to the target file.


		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;
		char openSeats = 'f';
		String builder = "";
		String temp = "";
		// read each line and write to System.out
		while ((line = br.readLine()) != null) {
			//					if (line.contains("open-seats-count")) {
			//						openSeats = line.charAt(43);
			//					}
			builder += line;
		}
		for (int i = 0; i < builder.length(); i++) {
			if (builder.charAt(i) != '\r'
					|| builder.charAt(i) != '\f'
					|| builder.charAt(i) != '\n'
					|| builder.charAt(i) != ' '
					|| !Character.isWhitespace(builder.charAt(i))) {
				temp += builder.charAt(i);
			}
		}
		System.out.println(temp);
		//				System.out.print(openSeats);

	}

}
