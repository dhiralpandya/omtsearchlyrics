/**
   Copyright 2013 Dhiral Pandya

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.omt.lyrics.lyricsparser.impl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.omt.lyrics.beans.Lyrics;
import com.omt.lyrics.exception.SearchLyricsException;
import com.omt.lyrics.lyricsparser.LyricsParser;
import com.omt.lyrics.util.HtmlUtil;
import com.omt.lyrics.util.Sites;

/**
 * This parser is used to parse all lyrics of www.metrolyrics.com {@link Sites}
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 10 Sep 2013
 * @version 1.0
 * 
 */
public class MetroLyricsParser implements LyricsParser {

	@Override
	public List<Lyrics> getLyrics(List<URL> urls) throws SearchLyricsException {
		List<Lyrics> lyrics = new ArrayList<Lyrics>();

		if (urls != null) {

			for (URL url : urls) {
				Lyrics lyric = parse(url.toString());
				if (lyric != null) {
					lyrics.add(lyric);
				}
			}

		}

		return lyrics;
	}

	/**
	 * Parse all lyrics for url.
	 * 
	 * @param url
	 * @return
	 */
	private Lyrics parse(String url) throws SearchLyricsException {
		Lyrics lyrics = null;
		try {
			Document document = Jsoup.connect(url).get();
			String data = "";

			Elements elements = document.getElementsByAttributeValueContaining(
					"class", "lyrics-body");

			if (elements != null && elements.size() > 0) {

				for (Element element : elements) {

					Elements pTags = element.getElementsByTag("p");

					if (pTags != null && pTags.size() > 0) {

						for (Element pTag : pTags) {

							String dataLine = HtmlUtil
									.replaceBrWithNewLine(pTag.html());
							dataLine = HtmlUtil.removeHTMLTags(dataLine) + "\n";
							data += dataLine;

						}
					}

				}

			}

			if (data.length() > 0) {
				lyrics = new Lyrics();
				lyrics.setLink(url);
				lyrics.setText(data);
				lyrics.setSites(Sites.METROLYRICS);
			}

		} catch (IOException e) {
			throw new SearchLyricsException(e);
		}
		return lyrics;
	}

}
