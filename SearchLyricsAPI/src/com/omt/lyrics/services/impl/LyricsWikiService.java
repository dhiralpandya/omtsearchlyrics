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
package com.omt.lyrics.services.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.omt.lyrics.beans.Lyrics;
import com.omt.lyrics.beans.LyricsServiceBean;
import com.omt.lyrics.exception.SearchLyricsException;
import com.omt.lyrics.services.LyricsService;
import com.omt.lyrics.util.HtmlUtil;
import com.omt.lyrics.util.Services;

/**
 * This service search your lyrics on LyricWikia Service
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 11 Sep 2013
 * @version 1.0
 * 
 */
public class LyricsWikiService implements LyricsService {

	private static final String NOT_FOUND = "Not found";

	@Override
	public List<Lyrics> getLyrics(LyricsServiceBean bean)
			throws SearchLyricsException {

		List<Lyrics> lyrics = new ArrayList<Lyrics>();

		String xml = callService(bean);

		if (xml != null && xml.length() > 0 && isLyricsFound(xml)) {
			try {
				String html = downloadString(getLyricsURL(xml));
				if (html != null && html.length() > 0) {
					Lyrics lyric = parse(html);
					if (lyric != null) {
						lyrics.add(lyric);
					}
				}
			} catch (Exception e) {
				throw new SearchLyricsException(e);
			}
		}

		return lyrics;
	}

	/**
	 * Parse html for lyrics.
	 * 
	 * @param html
	 * @return
	 */
	private Lyrics parse(String html) throws SearchLyricsException {
		Lyrics lyrics = null;

		try {
			Document document = Jsoup.parse(html);
			String data = document.getElementsByAttributeValueContaining(
					"class", "lyricbox").toString();

			if (data.length() > 0) {
				data = HtmlUtil.replaceBrWithNewLine(data);
				data = HtmlUtil.removeHTMLTags(data);
				data = HtmlUtil.removeQUOTTags(data);
				if (data.indexOf("<!--") > 0) {
					data = data.substring(0, data.indexOf("<!--"));
				}
				if (data.length() > 0) {
					lyrics = new Lyrics();
					lyrics.setLink(null);
					lyrics.setText(data);
					lyrics.setSites(null);
				}
			}

		} catch (Exception e) {
			throw new SearchLyricsException(e);
		}
		return lyrics;
	}

	/**
	 * Call LyricWikia Web Service
	 * 
	 * @param bean
	 * @return
	 */
	private String callService(LyricsServiceBean bean)
			throws SearchLyricsException {
		String xml = "";

		try {

			xml = downloadString(getServiceURL(bean));

		} catch (Exception e) {
			throw new SearchLyricsException(e);
		}

		return xml;
	}

	/**
	 * Get webservoce URL
	 * 
	 * @param bean
	 * @return
	 * @throws MalformedURLException
	 * @throws UnsupportedEncodingException
	 */
	private URL getServiceURL(LyricsServiceBean bean)
			throws MalformedURLException, UnsupportedEncodingException {

		String artist = "";

		if (bean.getSongAlbum() != null && bean.getSongAlbum().length() > 0) {
			artist = bean.getSongAlbum();
		} else {
			artist = bean.getSongArtist();
		}

		String url = "/api.php?func=getSong&artist=" + artist + "&song="
				+ bean.getSongName() + "&fmt=xml";
		// url = URLEncoder.encode(url, "UTF-8");
		return new URL(Services.LYRICSWIKIA.getProtocol(),
				Services.LYRICSWIKIA.getHost(), HtmlUtil.parseURL(url));
	}

	/**
	 * Is it contains lyrics.
	 * 
	 * @param xml
	 * @return
	 */
	private boolean isLyricsFound(String xml) throws SearchLyricsException {
		boolean isFound = true;
		try {
			Document document = Jsoup.parse(xml, "", Parser.xmlParser());
			Elements elements = document.getElementsByTag("lyrics");

			if (elements != null && elements.size() > 0) {
				for (Element lyricsTag : elements) {
					if (lyricsTag.text().equalsIgnoreCase(NOT_FOUND)) {
						isFound = false;
						break;
					}
				}

			}

		} catch (Exception e) {
			throw new SearchLyricsException(e);
		}
		return isFound;
	}

	/**
	 * If it contains lyrics then get it's url
	 * 
	 * @param xml
	 * @return
	 */
	private URL getLyricsURL(String xml) throws SearchLyricsException {
		URL url = null;
		try {
			Document document = Jsoup.parse(xml, "", Parser.xmlParser());
			Elements elements = document.getElementsByTag("url");

			if (elements != null && elements.size() > 0) {
				for (Element urlTag : elements) {
					if (urlTag.text() != null && urlTag.text().length() > 0) {
						url = new URL(urlTag.text());
						break;
					}
				}

			}

		} catch (Exception e) {
			throw new SearchLyricsException(e);
		}

		return url;
	}

	/**
	 * Download HTML
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	private static String downloadString(final URL url) throws IOException {
		final String agent = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US)";
		final URLConnection connection = url.openConnection();
		connection.setRequestProperty("User-Agent", agent);
		final InputStream stream = connection.getInputStream();
		return downloadString(stream);
	}

	private static String downloadString(final InputStream stream)
			throws IOException {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		int ch;
		while (-1 != (ch = stream.read()))
			out.write(ch);
		return out.toString();
	}
}
