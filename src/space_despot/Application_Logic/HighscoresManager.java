package space_despot.Application_Logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HighscoresManager {
	
	public List<HighscoreHolder> getHighscores() {
		
		String jsonString = "";      
        try {
        	URL oracle = new URL("http://cm-sds.com/get_highscores.php");
            BufferedReader in = new BufferedReader(
            new InputStreamReader(oracle.openStream()));            
			jsonString = in.readLine();		
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        	
		List<String> nicknames = new ArrayList<String>();
		List<String> scores = new ArrayList<String>();
        
		int currentIndexOne = 0;

        while (jsonString.indexOf("nickname", currentIndexOne) != -1) {  	
        	nicknames.add(jsonString.substring(jsonString.indexOf("nickname", currentIndexOne) + 11, 
        			jsonString.indexOf("\",", jsonString.indexOf("nickname", currentIndexOne) + 11)));       	        	
        	currentIndexOne = jsonString.indexOf("\",", jsonString.indexOf("nickname", currentIndexOne));
        }
        
        int currentIndexTwo = 0;
        while (jsonString.indexOf("score", currentIndexTwo) != -1) {  	
        	scores.add(jsonString.substring(jsonString.indexOf("score", currentIndexTwo) + 8, 
        			jsonString.indexOf("\"}", jsonString.indexOf("score", currentIndexTwo) + 8)));       	        	
        	currentIndexTwo = jsonString.indexOf("\"}", jsonString.indexOf("score", currentIndexTwo));
        }

        List<HighscoreHolder> highscores = new ArrayList<HighscoreHolder>();
        for (int i = 0; i < nicknames.size(); i++) {
        	highscores.add(new HighscoreHolder(nicknames.get(i), Integer.parseInt(scores.get(i))));
        }
        
		return highscores;
	}
	
	public void insertNewScore(String nickname, int score) {
		try {
            URL url = new URL("http://cm-sds.com/insert_score.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String data_string =
                    URLEncoder.encode("nickname", "UTF-8") + "=" + URLEncoder.encode(nickname, "UTF-8") + "&" +
                    URLEncoder.encode("score", "UTF-8") + "=" + URLEncoder.encode(Integer.toString(score), "UTF-8");

            bufferedWriter.write(data_string);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
