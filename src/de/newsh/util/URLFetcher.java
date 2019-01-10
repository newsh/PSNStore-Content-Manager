package de.newsh.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.time.LocalDate;

import com.google.gson.Gson;

import de.newsh.TitleJsonStructure.Image;
import de.newsh.TitleJsonStructure.JsonData;
import de.newsh.title.model.Title;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class URLFetcher extends Service<Title> {

	public String url;

	@Override
	protected Task<Title> createTask() {
		return new Task<Title>() {
			@Override
			protected Title call() throws Exception {
				Title fetchedTitle = new Title();
				try {
					URL titleApiUrl = new URL(convertStoreUrl(url));
					BufferedReader jsonString = new BufferedReader(new InputStreamReader(titleApiUrl.openStream()));

					JsonData jsonData = new Gson().fromJson(jsonString, JsonData.class);

					fetchedTitle.setName(jsonData.getName());
					fetchedTitle.setPlatform(jsonData.getPlayablePlatform().toString());
					fetchedTitle.setPrice(jsonData.getDefaultSku().getDisplayPrice());
					fetchedTitle.setReleaseDate(LocalDate.parse((jsonData.getReleaseDate().substring(0, 10))));

					String imageUrl = null;
					String fileName = jsonData.getId() + ".jpg";
					for (Image image : jsonData.getImages()) {
						if (image.getType() == 10 || image.getType() == 9)// type 10 is biggest resolution for title
																			// cover. 9 works too.
							imageUrl = image.getUrl();
					}
					saveTitleCover(imageUrl, fileName);
				} catch (Exception e) {
					throw e;
				}
				return fetchedTitle;
			}
		};
	}
	static String convertStoreUrl(String titleStoreUrl) {
		String languageCode = titleStoreUrl.substring(30,32); // de,en,fr,pt,...
		String countryCode = titleStoreUrl.substring(33,35); //de,ca,br,...
		String cid = titleStoreUrl.substring(titleStoreUrl.lastIndexOf("/")+1).trim(); // EP4352-CUSA00047_00-NNBLASTBUNNIESBU
		return "https://store.playstation.com/store/api/chihiro/00_09_000/container/"+countryCode+"/"+languageCode+"/9000/"+cid;
		
	}
	private static void saveTitleCover(String imageUrl, String fileName) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream("resources/titleCover/" + fileName);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}

	

}
