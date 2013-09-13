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

/**
 * Common HTMl parser functions.
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 10 Sep 2013
 * @version 1.0
 * 
 */
public class HtmlUtil {

	/**
	 * Replace all BR tags with new line.
	 * 
	 * @param html
	 * @return
	 */
	public static String replaceBrWithNewLine(String html) {
		return html.replaceAll("(?i)<br[^>]*>", "\n");
	}

	/**
	 * Remove all html tags from your String.
	 * 
	 * @param html
	 * @return
	 */
	public static String removeHTMLTags(String html) {
		return html.replaceAll("\\<.*?>", "");
	}

	/**
	 * Remove "& quot" tag from your String
	 * 
	 * @param html
	 * @return
	 */
	public static String removeQUOTTags(String html) {
		return html.replaceAll("&quot;", "");
	}

	/**
	 * Replace all blank space with %20
	 * 
	 * @param url
	 * @return
	 */
	public static String parseURL(String url) {
		return url.replaceAll("\\s", "%20");
	}

}
