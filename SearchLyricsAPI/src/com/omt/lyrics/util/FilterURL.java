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
package com.omt.lyrics.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This is used your {@link Sites} information to filter search links.
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 10 Sep 2013
 * @version 1.0
 * 
 */
public class FilterURL {

	/**
	 * @param args
	 */
	public static List<URL> filter(Sites sites, List<String> urls, int topMax)
			throws MalformedURLException {
		List<URL> filterURLs = new ArrayList<URL>();

		if (sites != null) {

			for (String urlString : urls) {
				if (urlString.toLowerCase().indexOf(sites.getName()) > 0) {
					URL url = new URL(urlString);
					filterURLs.add(url);
					if (filterURLs.size() >= topMax) {
						break;
					}
				}
			}

		} else {
			for (String urlString : urls) {

				URL url = new URL(urlString);
				filterURLs.add(url);
				if (filterURLs.size() >= topMax) {
					break;
				}

			}
		}

		return filterURLs;
	}

}
