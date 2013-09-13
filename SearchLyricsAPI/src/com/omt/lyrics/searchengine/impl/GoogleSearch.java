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
package com.omt.lyrics.searchengine.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.omt.lyrics.beans.SearchLyricsBean;
import com.omt.lyrics.common.Constants;
import com.omt.lyrics.exception.SearchLyricsException;
import com.omt.lyrics.searchengine.SearchEngine;
import com.omt.lyrics.util.Engines;
import com.omt.lyrics.util.SearchParams;

/**
 * This class is use to search your query in google. and return string of urls.
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 10 Sep 2013
 * @version 1.0
 * 
 */
public class GoogleSearch implements SearchEngine {

	@Override
	public List<String> search(String searchString)
			throws SearchLyricsException {
		List<String> urls = new ArrayList<String>();
		try {

			final URL url = encodeGoogleQuery(searchString);
			// Download the content from Google.
			System.out.println("Downloading [" + url + "]...\n");

			final String html = downloadString(url);

			urls = parseGoogleLinks(html);

		} catch (Exception e) {
			throw new SearchLyricsException(e);
		}

		return urls;
	}

	@Override
	public String getSearchString(SearchLyricsBean bean) {
		String searchThis = SearchParams.LYRICS_FOR + Constants.SPACE
				+ bean.getSearchStartWith() + Constants.SPACE
				+ bean.getSongName() + Constants.SPACE + bean.getSongAlbum()
				+ Constants.SPACE + bean.getSongArtist() + Constants.SPACE
				+ bean.getSearchEndWith() + Constants.SPACE
				+ SearchParams.SITES + bean.getSites().getHost();
		return searchThis;
	}

	/**
	 * Encode your query for google search
	 * 
	 * @param query
	 * @return
	 */
	private static URL encodeGoogleQuery(String query)
			throws SearchLyricsException {
		try {
			final StringBuilder localAddress = new StringBuilder();
			localAddress.append("/search?q=");

			final String encoding = URLEncoder.encode(query, "UTF-8");
			localAddress.append(encoding);

			return new URL(Engines.GOOGLE.getProtocol(),
					Engines.GOOGLE.getHost(), localAddress.toString());

		} catch (final IOException e) {
			// Errors should not occur under normal circumstances.
			throw new SearchLyricsException(e);
		}
	}

	/**
	 * Download google search data in form of html
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

	/**
	 * Get all google links from result HTML.
	 * 
	 * @param html
	 * @return
	 */
	private static List<String> parseGoogleLinks(final String html) {

		// These tokens are adequate for parsing the HTML from Google. First,
		// find a heading-3 element with an "r" class. Then find the next anchor
		// with the desired link. The last token indicates the end of the URL
		// for the link.
		final String token1 = "<h3 class=\"r\">";
		final String token2 = "<a href=\"";
		final String token3 = "\"";

		final List<String> links = new ArrayList<String>();

		// Loop until all links are found and parsed. Find each link by
		// finding the beginning and ending index of the tokens defined
		// above.
		int index = 0;
		while (-1 != (index = html.indexOf(token1, index))) {
			final int result = html.indexOf(token2, index);
			final int urlStart = result + token2.length();
			final int urlEnd = html.indexOf(token3, urlStart);
			final String urlText = html.substring(urlStart, urlEnd);
			// final URL url = new URL(urlText);
			// links.add(url);
			links.add(getValidURL(urlText));
			index = urlEnd + token3.length();
		}

		return links;

	}

	/**
	 * Get all valid url.
	 * 
	 * @param sUrl
	 * @return
	 */
	private static String getValidURL(String sUrl) {
		sUrl = sUrl.substring(sUrl.indexOf('=') + 1, sUrl.indexOf('&'));
		return sUrl;
	}
}
