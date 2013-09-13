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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.omt.lyrics.beans.Lyrics;
import com.omt.lyrics.exception.SearchLyricsException;
import com.omt.lyrics.lyricsparser.LyricsParser;
import com.omt.lyrics.util.HtmlUtil;
import com.omt.lyrics.util.Sites;

/**
 * This parser is used to parse all lyrics of www.lyrics.com {@link Sites}
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 10 Sep 2013
 * @version 1.0
 * 
 */
public class LyricsSiteParser implements LyricsParser {

	@Override
	public List<Lyrics> getLyrics(List<URL> urls) throws SearchLyricsException {
		List<Lyrics> lyrics = new ArrayList<Lyrics>();

		if (urls != null) {

			for (URL url : urls) {
				System.out.println("In Lyrics Site Parser :" + url.toString());
				String html = getHTML(url);
				if (html != null && html.length() > 0) {
					Lyrics lyric = parse(html, url.toString());
					if (lyric != null) {
						lyrics.add(lyric);
					}
				}
			}

		}

		return lyrics;
	}

	/**
	 * Get Html from URL
	 * 
	 * @param url
	 * @return
	 */
	private String getHTML(URL url) throws SearchLyricsException {
		String data = null;
		try {
			final String agent = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US)";
			final URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent", agent);
			final InputStream stream = connection.getInputStream();
			data = downloadString(stream);
		} catch (Exception exception) {
			throw new SearchLyricsException(exception);
		}
		return data;
	}

	private static String downloadString(final InputStream stream)
			throws IOException {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		int ch;
		while (-1 != (ch = stream.read()))
			out.write(ch);
		return out.toString();
	}

	/**
	 * Parse all lyrics for html.
	 * 
	 * @param url
	 * @return
	 */
	private Lyrics parse(String html, String url) throws SearchLyricsException {
		Lyrics lyrics = null;
		try {
			Document document = Jsoup.parse(html);
			// System.out.println("Document :" + document);
			String data = document.getElementById("lyric_space").toString();
			if (data.length() > 0) {
				data = HtmlUtil.replaceBrWithNewLine(data);
				data = HtmlUtil.removeHTMLTags(data);
				if (data.length() > 0) {
					lyrics = new Lyrics();
					lyrics.setLink(url);
					lyrics.setText(data);
					lyrics.setSites(Sites.LYRICS);

				}
			}

		} catch (Exception e) {
			throw new SearchLyricsException(e);
		}
		return lyrics;
	}

}
